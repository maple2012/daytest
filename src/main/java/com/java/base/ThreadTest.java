package com.java.base;

//比较两种方式
//优先使用，实现 Runnable;

public class ThreadTest {
    // 第一种实现
//    public static void main(String[] args) {
//        Window t1 = new Window();
//        Window t2 = new Window();
//        Window t3 = new Window();
//
//        t1.setName("窗口 1");
//        t2.setName("窗口 2");
//        t3.setName("窗口 3");
//
//        t1.start();
//        t2.start();
//        t3.start();
//    }

    public static void main(String[] args) {
        Wondow1 w = new Wondow1();
        Thread t1 = new Thread(w);
        Thread t2 = new Thread(w);
        Thread t3 = new Thread(w);

        t1.setName("窗口 1");
        t2.setName("窗口 2");
        t3.setName("窗口 3");

        t1.start();
        t2.start();
        t3.start();

    }

}
// 买票问题 第一种方式
class Window extends Thread{
    private static int ticket = 100;

    @Override
    public void run() {
        while (true){
            if(ticket > 0){
                System.out.println(getName()+":卖票，票号为："+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}

// 第二种方式
class Wondow1 implements Runnable {
    private int ticket = 100;
    @Override
    public void run() {
        while (true){
            if (ticket > 0){
                System.out.println(Thread.currentThread().getName()+":卖票，票号为："+ticket);
                ticket--;
            }else {
                break;
            }
        }
    }
}



