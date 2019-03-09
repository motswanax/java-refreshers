package com.svs.multithreading;

/**
 * Demo of multithreading
 * @author baike
 */
public class MultithreadDemo {

    // construct myThread object
    static MyThread thread = new MyThread("Child #1");
    static MyThread thread2 = new MyThread("Child #2");
    static MyThread thread3 = new MyThread("Child #3");

    public static void createThreads() {
        createMyThreadsObjects();

        for (int i = 0; i < 50; i++) {

            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
                e.printStackTrace();
            }
        }
        System.out.println("Main thread ending.");
    }

    private static void createMyThreadsObjects() {
        System.out.println("Main thread starting");

        // construct myThread object
       /* MyThread thread = new MyThread("Child #1");
        MyThread thread2 = new MyThread("Child #2");

        MyThread thread3 = new MyThread("Child #3");*/
    }

    public static void createThreadsUsingIsAlive() {
        createMyThreadsObjects();

        do {
            System.out.println(".");
            try {
                System.out.print(".");
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Main thread interrupted.");
                e.printStackTrace();
            }


        } while (thread.thread.isAlive() || thread2.thread.isAlive() || thread3.thread.isAlive());
        System.out.println("Main thread ending.");
    }

    /**
     * If you want to wait for a thread to finish you use joined()
     */
    public static void createThreadsUsingJoint() {
        createMyThreadsObjects();

        try {
            thread.thread.setPriority(Thread.NORM_PRIORITY);
            System.out.println("Child #1 priority is " + thread.thread.getPriority());
            thread2.thread.setPriority(Thread.MIN_PRIORITY);
            System.out.println("Child #2 priority is " + thread2.thread.getPriority());
            thread3.thread.setPriority(Thread.MAX_PRIORITY);
            System.out.println("Child #3 priority is " + thread3.thread.getPriority());
            /*thread.thread.join(); // wait until specified threads ends.
            System.out.println("Child #1 joined");
            thread2.thread.join();
            System.out.println("Child #2 joined");
            thread3.thread.join();
            System.out.println("Child #3 joined");*/
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
//        MultithreadDemo.createThreads();
//        MultithreadDemo.createThreadsUsingIsAlive();
        MultithreadDemo.createThreadsUsingJoint();

    }
}

class MyThread implements Runnable {
    Thread thread;

    String myThread;

    public MyThread(String myThread) {
        thread = new Thread(this, myThread);
        thread.start();
        this.myThread = myThread;
    }

    @Override
    public void run() {
        System.out.println(myThread + " Starting.");
        for (int count = 0; count < 10; count++) {
            try {
                Thread.sleep(400);
                System.out.println("In " + myThread + " count is " + count);
            } catch (InterruptedException e) {
                System.out.println(myThread + " interrupted");
                e.printStackTrace();
            }
            System.out.println(myThread + " terminated");
        }
    }


}