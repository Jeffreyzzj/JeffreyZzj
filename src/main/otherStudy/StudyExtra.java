package main.otherStudy;

import java.util.Arrays;

/**
 * @program: java-code-study
 * @description:
 * @author: zijie.zeng
 * @create: 2020-04-04 23:06
 * 包括：
 * 1。数组的copy
 */
public class StudyExtra {
    public void testArrayCopy() {
        int[] arr1= new int[]{1,2};
        int[] arr2 = new int[]{3,4};
        int[] newArr = Arrays.copyOf(arr1, arr1.length+arr2.length);
        System.out.println("新数组拷贝，因为需要扩容，完成");
        // param1: 需要copy的数组1， param2: 数组1开始copy的下标，
        // param3: copy到的数组2， param4: 从数组2的{param4}开始copy，param5: 需要copy数组1的长度
        System.arraycopy(arr2, 0, newArr, arr1.length, arr2.length);
        System.out.println("数组合并完成");
    }
}
