package com.data2.coding4j.thread;

/**
 * 单例模式
 *
 * @author wanglei
 */
public class SingletonModuleExample {
    /**
     * synchronized是作用在对象上的 double-check
     */
    private static SingletonModuleExample _instance;

    public static SingletonModuleExample getInstance() {
        if (_instance == null) {
            synchronized (SingletonModuleExample.class) {
                if (_instance == null) {
                    _instance = new SingletonModuleExample();
                }
            }
        }
        return _instance;
    }
}