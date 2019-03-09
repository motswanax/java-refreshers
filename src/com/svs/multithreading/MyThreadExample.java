package com.svs.multithreading;

/**
 * @author baike
 */
public class MyThreadExample extends Thread {

    private int threadId;
    private TargetClass targetClass;

    public MyThreadExample(int threadId, TargetClass targetClass) {
        this.threadId = threadId;
        this.targetClass = targetClass;
    }

    @Override
    public void run() {

        synchronized (targetClass) {
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            targetClass.call(threadId);
        }
    }
}
