package main.otherStudy;

public interface TestInterface {
    //接口的参数需要初始化，且为public static的，抽象类中的是普通变量
    public static int a = 2;

    //Java8之前的接口只能有抽象方法和不可变常量，
    public abstract void testFun7();
    //public abstract void testFun7(int num);

    //java8允许添加默认方法
    default void testFun8() {
        System.out.println("test");
    }
}
