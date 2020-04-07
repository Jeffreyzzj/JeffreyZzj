package main.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @program: java-code-study
 * @description: 归并排序算法
 * @author: zijie.zeng
 * @create: 2020-03-24 18:35
 */
public class GuiBingSortFun {
    public static Set<List<Integer>> poolSet = new HashSet<>();

    public static void main(String[] args) {
        int[] array = {3, 4, 34, 5, 43, 23, 65, 26, 75, 43};
        List<Integer> listRes = guiBingFun(array);
        System.out.println("结果为：" + listRes.toString());
    }

    public static List<Integer> guiBingFun(int[] array) {
        //将素组拆分
        fenArray(array);

        //合并
        while (poolSet.size()!=1) {
            addArray();
        }
        return poolSet.iterator().next();
    }

    public static void addArray() {
        List<Integer> setList1 = poolSet.iterator().next();
        poolSet.remove(setList1);
        List<Integer> setList2 = poolSet.iterator().next();
        poolSet.remove(setList2);

        List<Integer> saveList = new ArrayList<>();
        int i = 0, j = 0;
        while (i<setList1.size() && j<setList2.size()) {
            int list1 = setList1.get(i);
            int list2 = setList2.get(j);
            if (list1<list2) {
                saveList.add(list1);
                i++;
            } else {
                saveList.add(list2);
                j++;
            }
        }
        //当其中一个list完成后，把另外一个list放到saveList后面
        if (i==setList1.size()) {
            saveList.addAll(setList2.subList(j, setList2.size()));
        } else {
            saveList.addAll(setList1.subList(i, setList1.size()));
        }
        poolSet.add(saveList);
        //System.out.println("排序结果结果为："+ saveList.toString());
    }

    /**
     * @param array
     * @return
     * @description 将数组拆分
     */
    public static void fenArray(int[] array) {
        List<List<Integer>> fenList = new ArrayList<>();
        if (array.length > 0) {
            int index = 0;
            while (index < array.length) {
                List<Integer> listMid = new ArrayList<>();
                int value1 = array[index++];
                int value2 = -1;
                if (index < array.length) {
                    value2 = array[index++];
                }
                if (value2 == -1) {
                    listMid.add(value1);
                } else {
                    int small = value1 < value2 ? value1 : value2;
                    int big = value1 > value2 ? value1 : value2;
                    listMid.add(small);
                    listMid.add(big);
                }
                poolSet.add(listMid);
            }
        }
    }
}
