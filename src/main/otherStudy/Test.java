package main.otherStudy;

/**
 * @program: java-code-study
 * @description: https://blog.csdn.net/qq_37888382/article/details/88560757
 * @author: zijie.zeng
 * @create: 2020-04-02 21:17
 */
public class Test {

    Person person = new Person("Test");

    static {
        System.out.println("test static");
    }
    static void testStaticFun() {
        System.out.println("test static fun");
    }

    public Test() {
        System.out.println("test constructor");
    }

    public static void main(String[] args) {
        new MyClass();

        //Test.testa();
    }


    static class Person{
        static {
            System.out.println("person static");
        }

        public Person(String str){
            System.out.println("person "+str);
        }
    }

    static class MyClass extends  Test{
        Person person = new Person("MyClass");
        static{
            System.out.println("myclass static");
        }

        public MyClass(){
            System.out.println("myclass constructor");
        }
    }
}
