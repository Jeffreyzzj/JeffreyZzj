package main.threadstudy;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: java-code-study
 * @description: runnable实现多线程
 * @author: zijie.zeng
 * @create: 2019-12-17 23:40
 */
public class ThreadRunnable {
    public static void main(String[] args) {
        MyWindows mw = new MyWindows();
        Thread t1 = new Thread(mw);
        Thread t2 = new Thread(mw);
        Thread t3 = new Thread(mw);

        t1.setName("1窗口");
        t2.setName("2窗口");
        t3.setName("3窗口");

        t1.start();
        t2.start();
        t3.start();

    }

}
class MyWindows implements Runnable {
    public String name;
    public static int ticket = 100;

    public List<Integer> ticketList = new ArrayList<>();

    MyWindows() {

    }

    MyWindows(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (ticket > 0) {
                System.out.println(name + "进行售卖，剩余" + ticket);
                ticketList.add(ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}
