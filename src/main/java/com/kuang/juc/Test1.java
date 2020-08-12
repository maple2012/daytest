package com.kuang.juc;

public class Test1 {
    public static void main(String[] args) {
        Data data = new Data();
        new Thread(()->{
                for (int i=0;i<10;i++){
                    try {
                        data.increment();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

        },"A").start();

        new Thread(()->{
            try {
                for (int i=0;i<10;i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"B").start();

        new Thread(()->{
            for (int i=0;i<10;i++){
                try {
                    data.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        },"C").start();

        new Thread(()->{
            try {
                for (int i=0;i<10;i++) {
                    data.decrement();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"D").start();

    }
}

class Data{
    private int number = 0;

    // +1
    public synchronized void increment() throws InterruptedException{
        while (number != 0){
            this.wait();
        }
        number++;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notifyAll();
    }
    public synchronized void decrement() throws  InterruptedException{
        // 不能使用 if，会只执行一次
        while (number == 0) {
            this.wait();
        }
        number--;
        System.out.println(Thread.currentThread().getName()+"=>"+number);
        this.notifyAll();
    }
}
