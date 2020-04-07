package main.designModel.Utils;

/**
 * @program: java-code-study
 * @description: 数组处理工具类
 * @author: zijie.zeng
 * @create: 2020-04-02 20:39
 */
public class ArrayUtil {
    //通过快速排序查找最大值
    public static int intGetMax(int[] arrays) {
        int[] arraysMid = arrays.clone();
        getMaxByInteger(arraysMid, 0, arrays.length-1);
        return arraysMid[arrays.length-1];
    }

    public static void getMaxByInteger(int[] array, int start, int end) {
        int i=start, j=end;
        if (i<j) {
            int temp = array[i];
            while (i<j) {

                while (i<j && temp<=array[j]) j--;
                if (temp>=array[j]) i++;

                while (i<j && temp>=array[i]) i++;
                if (temp<=array[i]) {
                    array[j] = array[i];
                    j--;
                }
                array[i] = temp;
                quickSort(array, i+1, end);
            }
        }
    }

    /**
     * @description 快速排序
     * @param array
     * @param start
     * @param end
     */
    public static void quickSort(int[] array, int start, int end) {
        int i=start, j=end;
        if (i<j) {
            int temp = array[i];
            while (i<j) {

                while (i<j && temp<=array[j]) j--;
                if (temp>array[j]) {
                    array[i] = array[j];
                    i++;
                }
                while (i<j && temp>array[i]) i++;
                if (temp<=array[i]) {
                    array[j] = array[i];
                    j--;
                }
                array[i] = temp;
                quickSort(array, start, i-1);
                quickSort(array, i+1, end);
            }
        }
    }
}
