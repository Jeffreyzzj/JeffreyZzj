package main.codeStudy;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: java-code-study
 * @description: 比较两个数组中，第一个数组中每一个字符的字符是否大于第二个数组
 * @author: zijie.zeng
 * @create: 2020-03-29 18:16
 */
public class TwoListCompareElement {
    public static void main(String[] args) {
        String s1 = "aaabbbc";
        String s2 = "aabbc";
        StringBuilder sb;
        boolean res = getStrTwo(s1, s2);
        System.out.println(res);
    }
    public static boolean getStrTwo(String str1, String str2) {
        Map<Character, Integer> map1 = getCharMap(str1.toCharArray());
        Map<Character, Integer> map2 = getCharMap(str2.toCharArray());
        for(Map.Entry<Character, Integer> res : map1.entrySet()) {
            Integer num1 = res.getValue();
            Integer num2 = map2.get(res.getKey());
            if (num2==null) {
                continue;
            }
            if (num1<=num2) {
                return false;
            }
        }
        return true;

    }
    public static Map<Character, Integer> getCharMap(char[] chars) {
        Map<Character, Integer> mapRes = new HashMap<>();
        if (chars.length==0) {
            return mapRes;
        }
        for (int i=0; i<chars.length; i++) {
            if (!mapRes.containsKey(chars[i])) {
                int num = 0;
                for (int j=i; j<chars.length; j++) {
                    if (chars[i]==chars[j]) {
                        num++;
                    }
                }
                mapRes.put(chars[i], num);
            }
        }
        return mapRes;
    }
}
