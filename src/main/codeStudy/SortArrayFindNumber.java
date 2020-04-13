package main.codeStudy;

/**
 * @program: java-code-study
 * @description: 升序数组找目标值
 * @author: zijie.zeng
 * @create: 2020-04-02 10:01
 */
public class SortArrayFindNumber {
    public static void main(String[] args) {
        int[] res = preSearchRange();
        System.out.println("结果为：" + res[0] + " and " + res[1]);
    }

    public static int[] preSearchRange() {
        int[] arr = {5, 7, 7, 8, 8, 10};
        int target = 8;
        //自己的实现
        //return searchRange(arr, target);
        //别人的实现
        return answer(arr, target);
    }

    public static int[] searchRange(int[] nums, int target) {

        int[] resArr = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (resArr[0] == -1) {
                    resArr[0] = i;
                    resArr[1] = i;
                } else {
                    resArr[1] = i;
                }
            }
        }

        return resArr;
    }

    public static int[] answer(int[] nums, int target) {
        int[] result = new int[2];

        if (nums.length == 0) {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        result[0] = findFirst(nums, nums.length, target);
        result[1] = findLast(nums, nums.length, target);
        return result;
    }

    public static int findFirst(int[] a, int len, int key) {
        if (len < 1)
            return -1;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key && (mid - 1 < 0 || a[mid - 1] != key)) {
                return mid;
            } else if (a[mid] >= key) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static int findLast(int[] a, int len, int key) {
        if (len < 1)
            return -1;
        int low = 0;
        int high = len - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (a[mid] == key && (mid + 1 >= len || a[mid + 1] != key)) {
                return mid;
            } else if (a[mid] <= key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
