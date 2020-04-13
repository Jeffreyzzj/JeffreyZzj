package main.codeStudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: Z 字形变换
 * @URL https://leetcode-cn.com/problems/zigzag-conversion/
 * @author: zijie.zeng
 * @create: 2020-04-06 19:24
 */
public class StringToElementZ {
    public static void main(String[] args) {
        String value = "abcdefg";
        String res = getNConversionList(value, 3);
        System.out.println("===");
    }
    public static String getNConversionList(String s, int numRows) {
        if (numRows==1) {
            return s;
        }
        List<StringBuilder> resList = new ArrayList<>();
        for (int i=0; i<numRows; i++) {
            resList.add(new StringBuilder());
        }

        char[] charArray = s.toCharArray();
        //存到第几个list中
        int index = 0;
        //是否向下遍历
        boolean under = false;
        for (char c : s.toCharArray()) {
            resList.get(index).append(c);
            if (index==0 || index==numRows-1) under = !under;
            index = under ? ++index : --index;
        }

        StringBuilder sb = new StringBuilder();
        for (StringBuilder sbParam : resList) {
            sb.append(sbParam);
        }
        return sb.toString();

    }
}
