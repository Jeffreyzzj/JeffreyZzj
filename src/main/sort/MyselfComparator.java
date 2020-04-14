package main.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 自定义排序
 * @author: zijie.zeng
 * @create: 2020-04-13 22:37
 */
public class MyselfComparator {
    public static void main(String[] args) {
        Integer[] arrays = new Integer[]{12,13,1,8,5};
        List<Integer> integerList = Arrays.asList(arrays);

        myselfTestComparator(arrays);

    }
    private static void myselfTestComparator(Integer[] arrays) {
        Arrays.sort(arrays, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println();
    }

}
