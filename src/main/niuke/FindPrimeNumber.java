package main.niuke;

import main.designModel.Utils.ArrayUtil;
import main.designModel.Utils.PrimeNumber;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 寻找素数
 * @author: zijie.zeng
 * @create: 2020-04-02 20:02
 */
public class FindPrimeNumber {
    public static void main(String[] args) {
        int[] pre = {2, 8, 10, 18, 25, 11};
        FindPrimeNumber primeNumber = new FindPrimeNumber();
        primeNumber.getPrimeNumBySum(pre);
    }

    public void getPrimeNumBySum(int[] pre) {
        //找到数组中的最大值
        int max = ArrayUtil.intGetMax(pre);
        //需要处理的
        PrimeNumber primeNum = new PrimeNumber(max);
        List<Integer> primeList = primeNum.getPrimeNum();

        //处理素数和
        int[] res = getPrimeNum(primeList, pre);
        for (int i=0 ;i<pre.length; i++) {
            System.out.println("pre: "+pre[i] + ", and res: "+res[i]);
        }
    }
    public static int[] getPrimeNum(List<Integer> primeList, int[] pre) {
        int[] res = new int[pre.length];

        for (int i=0; i<pre.length; i++) {
            int num = 0;
            int index = 0;
            int processMid = pre[i]/2;
            while (index<primeList.size() && primeList.get(index)<=processMid) {
                for (int j=index; j<primeList.size(); j++) {
                    if (primeList.get(index) + primeList.get(j) == pre[i]) {
                        num++;
                        break;
                    }
                }
                index++;
            }
            res[i] = num;
        }
        return res;
    }

}
