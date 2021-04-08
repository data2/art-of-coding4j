package com.data2.coding4j.thread.wait;

class ResNew {
    String name;
    String sex;
    boolean flag = false;
}

class InputNew implements Runnable {
    private ResNew r;

    public InputNew(ResNew r) {
        // TODO Auto-generated constructor stub
        this.r = r;
    }

    public void run() {
        int x = 0;
        while (true) {
            synchronized (r) {
                if (r.flag == true){
                    try {
                        r.wait();//释放当前对象锁
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (x == 0) {
                    r.name = "mike";
                    r.sex = "man";
                } else {
                    r.name = "丽丽";
                    r.sex = "女女女";
                }
                x = ++x % 2;
                r.flag = true;
                r.notify();//唤醒其他等待线程
            }
        }
    }
}

class OutputNew implements Runnable {
    private ResNew r;

    OutputNew(ResNew r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            synchronized (r) {
                if (r.flag == false){
                    try {
                        r.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(r.name + "----" + r.sex);
                r.flag = false;
                r.notify();
            }
        }
    }
}

public class CommunicateNew {

    public static void main(String[] args) {
        ResNew r = new ResNew();
        InputNew in = new InputNew(r);
        OutputNew out = new OutputNew(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();

    }
}
