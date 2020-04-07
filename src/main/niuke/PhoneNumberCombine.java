package main.niuke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: java-code-study
 * @description: 电话号码的字母组合
 * @url https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 * @author: zijie.zeng
 * @create: 2020-04-06 21:11
 */
public class PhoneNumberCombine {
    static Map<Character, String> phone = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    public static void main(String[] args) {
        String str = "";
        List<String> res = letterCombinations(str);
    }
    public static List<String> letterCombinations(String digits) {
        List<String> resList = new ArrayList<>();
        if (digits.equals("")) {
            return resList;
        }
        resList = getCombine(digits, 0);
        return resList;
    }
    public static List<String> getCombine(String digits, int index) {
        Character num = digits.charAt(index);
        List<String> newList = new ArrayList<>();
        List<String> resList = new ArrayList<>();
        if (++index<digits.length()) {
            resList = getCombine(digits, index);
        } else if (index==digits.length()){
            for (Character c : phone.get(num).toCharArray()) {
                newList.add(c.toString());
            }
            return newList;
        }

        for (Character c : phone.get(num).toCharArray()) {
            for (String str : resList) {
                newList.add(c+str);
            }
        }
        return newList;
    }
}
