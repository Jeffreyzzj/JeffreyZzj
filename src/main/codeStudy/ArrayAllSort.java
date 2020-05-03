package main.codeStudy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 数组全排序1
 * @url https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode/
 * @author: zijie.zeng
 * @create: 2020-04-07 10:08
 */
public class ArrayAllSort {
    public static void main(String[] args) {
        preFun();
    }

    public static void preFun() {
        int[] param = {1, 2, 3, 4, 5};
        permute(param);
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new LinkedList();

        // convert nums into list since the output is a list of lists
        ArrayList<Integer> nums_lst = new ArrayList<Integer>();
        for (int num : nums) {
            nums_lst.add(num);
        }
        funBack(nums_lst.size(), nums_lst, output, 0);
        return output;
    }

    /**
     * @description 思路：
     * @param n
     * @param nums
     * @param output
     * @param first
     */
    public static void funBack(int n, ArrayList<Integer> nums, List<List<Integer>> output,
                               int first) {
        if (n==first) {
            output.add(new ArrayList<>(nums));
        }
        for (int i=first; i<n; i++) {
            Collections.swap(nums, i, first);
            funBack(n, nums, output, first+1);
            Collections.swap(nums, i, first);
        }

    }
    /*
    https://job.bytedance.com/referral/pc/position/detail/6798465717508245767?token=MjsxNTg0Njk2MTk0NTYxOzY3MDc5ODczOTc3MTM0OTU1NjY7NjgwNjIxNzYzMTA0NzI4OTEwMQ
    https://job.bytedance.com/referral/pc/position/detail/6797589675021175048?token=MjsxNTg0Njk2MTk0NTYxOzY3MDc5ODczOTc3MTM0OTU1NjY7NjgwNjIxNzYzMTA0NzI4OTEwMQ
    https://job.bytedance.com/referral/pc/position/detail/6797274319446608135?token=MjsxNTg0Njk2MTk0NTYxOzY3MDc5ODczOTc3MTM0OTU1NjY7NjgwNjIxNzYzMTA0NzI4OTEwMQ
    https://job.bytedance.com/referral/pc/position/detail/6797326519111780615?token=MjsxNTg0Njk2MTk0NTYxOzY3MDc5ODczOTc3MTM0OTU1NjY7NjgwNjIxNzYzMTA0NzI4OTEwMQ
     */
}
