package main.sort;

/**
 * @program: java-code-study
 * @description: 拍讯算法
 * @author: zijie.zeng
 * @create: 2019-12-20 00:09
 */
public class QuickSortFun {

    public static void main(String[] args) {
        quickSort();
    }

    /**
     * 快速排序
     * @url https://blog.51cto.com/13733462/2113397
     * @URL https://baijiahao.baidu.com/s?id=1630690516749462635&wfr=spider&for=pc
     */
    public static void quickSort() {
        int[] array = {3, 4, 34, 5, 43, 23, 65, 26, 75, 43};

        quicktest(array, 0, array.length - 1);
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+"  ");
        }
    }
    public static void quicktest(int[] array, int start, int end) {
        int i = start;
        int j = end;
        if (i<j) {
            int temp = array[i];
            while (i<j&&i<array.length-1) {
                while (i<j&&temp<=array[j]) j--;
                if (temp>array[j]) {
                    array[i] = array[j];
                    i++;
                }
                while (i<j&&temp>=array[i]) i++;
                if (temp<array[i]) {
                    array[j] = array[i];
                    j--;
                }
            }
            array[i] = temp;
            quicktest(array, start, i);
            quicktest(array, i+1, end);
        }
    }

}
