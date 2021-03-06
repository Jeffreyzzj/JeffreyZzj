package main.game;

import java.util.Scanner;

/**
 * @program: java-code
 * @description: 1～100
 * @author: zijie.zeng
 * @create: 2020-05-03 23:16
 */
public class ZeroToHundred {
    private static final String str1 = "请输入%s到%s之间的数";
    private static final String str2 = "请重新输入%s到%s之间的数";
    public static void main(String[] args) {
        int target = (int) (Math.random() * 100);
        int left = 0;
        int right = 100;
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        while (target != input) {
            if (input<=left || input>=right) {
                System.out.println(String.format(str2, left, right));
                continue;
            }
            if (input < target) {
                left = input;
            }
            if (input > target) {
                right = input;
            }

            System.out.println(String.format(str1, left, right));
            input = sc.nextInt();
        }
        System.out.println("over, the target number is " + target);
    }
}
