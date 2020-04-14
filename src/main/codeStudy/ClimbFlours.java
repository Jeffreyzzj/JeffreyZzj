package main.codeStudy;

/**
 * @program: java-code-study
 * @description: 70. 爬楼梯
 * @URL https://leetcode-cn.com/problems/climbing-stairs/
 * @author: zijie.zeng
 * @create: 2020-04-13 22:00
 */
public class ClimbFlours {

    public static void main(String[] args) {
        int num = climbStairs(2);
        System.out.println(num);
    }
    public static int climbStairs(int n) {
        int[] nums = new int[n+1];
        nums[0] = 1;
        nums[1] = 1;
        if (n+1<=2) {
            return nums[n];
        }
        for (int i=2; i<n+1; i++) {
            nums[i] = nums[i-1] + nums[i-2];
        }
        return nums[n];
    }
}
