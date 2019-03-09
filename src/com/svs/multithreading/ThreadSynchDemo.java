package com.svs.multithreading;

/**
 * @author baike
 */
public class ThreadSynchDemo {

    public static void main(String[] args) {
        /*First first = new First();
        Second one = new Second(first, "welcome");
        Second two = new Second(first, "new");
        Second three = new Second(first, "programmer");*/

        // Example with the MyThreadExample & TargetClass
        TargetClass targetClass = new TargetClass(); // single instance of TargetClass supplied to 3 threads
        MyThreadExample t1 = new MyThreadExample(1, targetClass);
        MyThreadExample t2 = new MyThreadExample(2, targetClass);
        MyThreadExample t3 = new MyThreadExample(3, targetClass);

        t1.start();
        t2.start();
        t3.start();
    }
}

class First {

    /**
     * Prints the given message at 1s intervals. It is synchronized to avoid clashes.
     * @param msg the message
     */
    synchronized void display(String msg) { // read more on process and thread synchronization.
        System.out.print(" [ " + msg);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(" ] ");
    }
}

class Second extends Thread {
    String msg;
    First fobj;

    public Second(First fobj, String msg) {
        this.msg = msg;
        this.fobj = fobj;
        start();
    }

    @Override
    public void run() {
        fobj.display(msg);
    }
}
