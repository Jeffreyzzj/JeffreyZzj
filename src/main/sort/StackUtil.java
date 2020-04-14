package main.sort;

import java.util.LinkedList;

/**
 * @program: java-code-study
 * @description: 自己实现的栈
 * @author: zijie.zeng
 * @create: 2020-04-14 10:21
 */
public class StackUtil {
    public LinkedList stack = new LinkedList();
    /*public StackUtil() {

    }*/
    public void push(Object o) {
        stack.push(o);
    }
    public Object pop() {
        return stack.pop();
    }
}
