package main.niuke;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: 网易神奇数
 * @author: zijie.zeng
 * @create: 2020-01-05 23:51
 * @URL：https://www.nowcoder.com/practice/51dcb4eef6004f6f8f44d927463ad5e8? tpId=98&tqId=32825&tPage=1&rp=1&ru=/ta/2019test&qru=/ta/2019test/question-ranking
 */
public class WangyiShenQiShu {
    public static void main(String[] args) {

        /*List<String> specificNums = getSpecificNumbers(2, 5);
        System.out.println("get specific num");

        int res = calculateList(specificNums);
        System.out.println("end");*/

        int start = 2;
        int end = 5;

        int res = getHasSpecificNum(start, end);
        System.out.println("--------------");

    }

    public static int getHasSpecificNum(int start, int end) {
        int startNum = (start/3)*2;
        int startFlag = start/3==0? 0: 1;
        int startHas = startNum+startFlag;

        int endNum = (end/3)*2;
        int endFlag = end/3==0? 0: 1;
        int endHas = endNum+endFlag;

        return endHas-startHas;
    }

    //生成神奇数
    public static List<String> getSpecificNumbers(int start, int end) {
        List<String> listRes = new ArrayList<>();

        String flag = new String();

        for (int i = 1; i < end + 1; i++) {
            flag = flag + i;
            if (i < start) {
                continue;
            }
            listRes.add(flag);
        }
        return listRes;
    }

    //计算神奇数
    public static int calculateList(List<String> paramLists) {
        int res = 0;

        for (int i = 0; i < paramLists.size(); i++) {
            int[] param = getArrayByListElement(paramLists.get(i));
            boolean flag = calculateNum(param);
            if (flag) {
                res++;
            }
        }

        return res;
    }

    //求一个数，分解后的和,可以：返回true
    public static boolean calculateNum(int[] numArray) {
        if (numArray.length <= 1) {
            return numArray[0] % 3 == 0;
        }
        int res = 0;
        for (int i = 0; i < numArray.length; i++) {
            res += numArray[i];
        }

        if (res > 10) {
            String resMid = String.valueOf(res);
            String[] strParam = resMid.split("");
            int[] intParam = new int[strParam.length];
            for (int i = 0; i < strParam.length; i++) {
                intParam[i] = Integer.parseInt(strParam[i]);
            }
            return calculateNum(intParam);
        } else {
            return res % 3 == 0;
        }
    }

    public static int[] getArrayByListElement(String param) {
        String[] strParam = param.split("");
        int[] intParam = new int[strParam.length];
        for (int i = 0; i < strParam.length; i++) {
            intParam[i] = Integer.parseInt(strParam[i]);
        }
        return intParam;
    }
}
