package main.codeStudy;

/**
 * @program: java-code-study
 * @description: 第n个小的数
 * @author: zijie.zeng
 * @create: 2020-03-20 21:34
 */
public class TheNedSmall {
    public static void main(String[] args) {
        quickSort();
    }

    /**
     * 快速排序
     * @url https://blog.51cto.com/13733462/2113397
     */
    public static void quickSort() {
        //3  4  5  23  26  34  43  43  65  75
        int[] array = {3, 4, 34, 5, 43, 23, 65, 26, 75, 43};

        int need = 9;
        int res = findKth(array, need);
        System.out.println("获得第"+ need +"的结果为 ： "+res);
        for (int i=0; i<array.length; i++) {
            System.out.print(array[i]+"  ");
        }
    }
    public static int findKth(int[] arr, int k) {

        return quickFind(arr, k, 0, arr.length-1);
    }

    public static int quickFind(int[] arr, int k, int start, int end) {
        int i = start;
        int j = end;
        if (i<j) {
            int temp = arr[i];
            while (i<j) {
                while (i<j && temp<=arr[j]) j--;
                if (i<j) {
                    arr[i] = arr[j];
                }
                while (i<j && temp>=arr[i]) i++;
                if (i<j) {
                    arr[j] = arr[i];
                }
            }
            arr[i] = temp;
            if (i!=0 && i==k-1) {
                return arr[i];
            }
            int res = quickFind(arr, k, start, i);
            if (res!=-1) {
                return res;
            }
            res = quickFind(arr, k, i+1, end);
            if (res != -1) {
                return res;
            }
        }
        return -1;
    }
}
