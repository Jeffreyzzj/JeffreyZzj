package main.niuke;

/**
 * @program: java-code-study
 * @description: 牛客网在线编程
 * @author: zijie.zeng
 * @create: 2019-12-23 23:59
 */
public class FindSingleAndDouble {
    /**
     * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
     * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
     * @url https://www.nowcoder.com/practice/beb5aa231adc45b2a5dcc5b62c93f593?tpId=13&tqId=11166&tPage=1&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
     * @param args
     */
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        /*int[] res = fun1(array);
        System.out.println("...");*/

        fun2(array);
        System.out.println("===");

    }

    public static void fun2(int[] array) {
        int i=0;
        int flag=i;
        while (i<array.length) {
            //找到单数
            if(array[i]%2!=0) {
                processArray(array, flag, i);
                flag++;
            }

            i++;
        }
    }

    public static void processArray(int[] array, int start, int end) {
        if (start < end || start < array.length || end <= array.length) {
            for(int i=end; i>start; i--) {
                int flag = array[i];
                array[i] = array[i-1];
                array[i-1] = flag;
            }
        }
    }

    public static int[] fun1(int[] array) {
        int[] singleArray = new int[array.length];//p
        int[] doubleArray = new int[array.length];//q
        int p = 0;
        int q = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                doubleArray[q] = array[i];
                q++;
            } else {
                singleArray[p] = array[i];
                p++;
            }
        }
        for (int i = 0; i < doubleArray.length; i++) {
            singleArray[p] = doubleArray[i];
            if (doubleArray[i + 1] != 0) {
                p++;
            } else {
                break;
            }
        }
        array = singleArray;
        return array;
    }
}






