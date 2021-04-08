package com.data2.coding4j.thread.wait;

class Res {
    String name;
    String sex;
}

class Input implements Runnable {
    private Res r;

    public Input(Res r) {
        // TODO Auto-generated constructor stub
        this.r = r;
    }

    public void run() {
        int x = 0;
        while (true) {
            synchronized (r) {
                if (x == 0) {
                    r.name = "mike";
                    r.sex = "man";
                } else {
                    r.name = "丽丽";
                    r.sex = "女女女";
                }
                x = ++x % 2;
            }
        }
    }
}

class Output implements Runnable {
    private Res r;
    Object obj = new Object();

    Output(Res r) {
        this.r = r;
    }

    public void run() {
        while (true) {
            synchronized (r) {
                System.out.println(r.name + "----" + r.sex);
            }
        }
    }
}

public class Communicate {

    public static void main(String[] args) {
        Res r = new Res();
        Input in = new Input(r);
        Output out = new Output(r);

        Thread t1 = new Thread(in);
        Thread t2 = new Thread(out);

        t1.start();
        t2.start();

    }
}
