package main.codeStudy;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

/**
 * @program: java-code-study
 * @description: Access Log 处理
 * @author: zijie.zeng
 * @create: 2020-04-12 18:00
 */
public class ChangTingKeJiLogProcess {
    public static void main(String[] args) {
        testSelect();
    }
    public static void testSelect() {
        List<Integer> res = new ArrayList<>();
        //接受数据
        Scanner sc = new Scanner(System.in);
        //共有几组
        System.out.println("请输入数据组数");
        int groups = sc.nextInt();
        Set<Long> logInfoSet = new HashSet<>();

        for (int i=0; i<groups; i++) {
            System.out.println("请输入第"+ (i+1)+"组数据的条数");
            int num = sc.nextInt();
            System.out.println("第"+(i+1)+"组，条数" + num);
            for (int j = 0; j<num; j++) {
                Long time = sc.nextLong();
                logInfoSet.add(time);
            }
        }
        //查询次数
        System.out.println("请输入查询的组数");
        int selectNum = sc.nextInt();
        System.out.println("共有"+selectNum+"次查询");
        List<Long[]> selectGroups = new ArrayList<>();
        for (int i=0; i<selectNum; i++) {
            System.out.println("请输入第"+(i+1)+"次查询范围");
            Long[] selectGroup = new Long[2];
            Long start = sc.nextLong();
            selectGroup[0] = start;
            Long end = sc.nextLong();
            selectGroup[1] = end;
            selectGroups.add(selectGroup);
        }

        System.out.println("开始查询");

        for (Long[] array : selectGroups) {
            int num = 0;
            for (Long info : logInfoSet) {

                if (array[0]<=info && info<= array[1]) {
                    num++;
                }

            }
            res.add(num);
        }

        res.stream().forEach(System.out::println);
    }
}
