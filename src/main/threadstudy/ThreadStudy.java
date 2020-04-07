package main.threadstudy;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @program: java-code-study
 * @description: 多线程学习
 * @author: zijie.zeng
 * @create: 2019-12-17 23:22
 */
public class ThreadStudy {
    public static void main(String[] args) {
        Window w1 = new Window("1窗口");
        Window w2 = new Window("2窗口");
        Window w3 = new Window("3窗口");

        w1.start();
        w2.start();
        w3.start();
        System.out.println("over");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(w1.getName()+"票数："+w1.ticketList.toString());
        System.out.println(w2.getName()+"票数："+w2.ticketList.toString());
        System.out.println(w3.getName()+"票数："+w3.ticketList.toString());
    }
}

class Window extends Thread {
    public String name;
    public static int ticket = 100;

    public List<Integer> ticketList = new ArrayList<>();

    Window() {

    }

    Window(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (true) {
            if (ticket>0) {
                System.out.println(name+"进行售卖，剩余"+ticket);
                ticketList.add(ticket);
                ticket--;
            } else {
                break;
            }
        }
    }
}
