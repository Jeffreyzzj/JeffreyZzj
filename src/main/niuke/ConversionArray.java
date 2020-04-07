package main.niuke;

/**
 * @program: java-code-study
 * @description: 搜索旋转排序数组
 * @author: zijie.zeng
 * @create: 2020-04-06 17:27
 */
public class ConversionArray {
    public static void main(String[] args) {
        int[] nums = {1,3};
        int res = conversionArraySearchTarget(nums,3);
        System.out.println("=====");
    }
    public static int conversionArraySearchTarget(int[] nums, int target) {
        if (nums.length==0) {
            return -1;
        }
        int left = 0;
        int right = nums.length-1;

        int mid = 0;
        while (true) {
            mid = (right + left)/2;
            if (nums[mid] == target) {
                break;
            } else if (left>=right) {
                return -1;
            }

            if (nums[left]<nums[mid]) {
                //左半段有序
                if (nums[left]<=target && target<=nums[mid]) {
                    right = --mid;
                } else {
                    left = ++mid;
                }
                continue;
            } else if (nums[mid+1]<=nums[right]) {
                //右半段有序
                if (nums[mid+1]<=target && target<=nums[right]) {
                    left = ++mid;
                } else {
                    right = --mid;
                }
                continue;
            }
        }
        return mid;
    }
}
