package com.common.experiment.ref;

/**
 * Client简介
 *
 * @author jiaxianyang
 * @date 2021-11-13 09:40
 */
public class Client {
    public static void main(String[] args) {
        Salad salad = new Salad(new Apple("红富士"));
        //通过WeakReference的get()方法获取Apple
        System.out.println("Apple: " + salad.get());
        System.gc();
        //休眠一下，在运行的时候加上虚拟机参数-XX:+PrintGCDetails，输出gc信息，确定gc发生了。
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //如果为空代表被回收了
        if (salad.get() == null) {
            System.out.println("clear Apple. ");
        }
    }
}
