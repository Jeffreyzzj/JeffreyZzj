package main.otherStudy;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: java-code-study
 * @description: 测试接口部分知识，实现类
 * @author: zijie.zeng
 * @create: 2020-04-13 23:30
 */
public class TestInterfaceClass {
    public static void main(String[] args) {
        //自定义
        testDoInterfaceFun(() -> System.out.println("aaa"));

        Function<Integer, Integer> fc = i -> i+1;
        testDoInterfaceFun(fc, 5);
    }
    private static void testDoInterfaceFun(TestInterface testInterface) {
        testInterface.testFun7();
    }

    private static void testDoInterfaceFun(Function<Integer, Integer> function, int num) {
        int res = function.apply(num);
        System.out.println(res);
    }
}
