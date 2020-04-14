package main.sort;

import java.util.LinkedList;

/**
 * @program: java-code-study
 * @description: 队列
 * @author: zijie.zeng
 * @create: 2020-04-14 10:25
 */
public class QueueUtil {
    public LinkedList<Object> stack = new LinkedList();
    public void push(Object o) {
        stack.offer(o);
    }
    public Object pop() {
        return stack.pop();
    }
    public boolean isEmpty() {
        return stack.isEmpty();
    }
}
