/**
 * FileName:   StackOOMTest.java
 *
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.oom;

/**
 * @author wanglei
 *
 */
public class StackOOMTest {

    public static void main(String[] args) {
        new StackOOMTest().stackLeakByThread();
    }

    private void dontStop() {
        while (true) {
        }
    }

    public void stackLeakByThread() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }

            });
            thread.start();
        }
    }
}
