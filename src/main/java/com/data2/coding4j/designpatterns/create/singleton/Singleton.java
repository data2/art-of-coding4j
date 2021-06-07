package com.data2.coding4j.designpatterns.create.singleton;

public class Singleton {

//	private static Singleton instance = null;

    private Singleton() {
    }

    //synchronized关键字加在了内部，也就是说当调用的时候是不需要加锁的，只有在instance为null，
    //并创建对象的时候才需要加锁，性能有一定的提升。但是，这样的情况，还是有可能有问题的，
    //看下面的情况：在Java指令中创建对象和赋值操作是分开进行的，也就是说instance = new Singleton();
    //语句是分两步执行的。但是JVM并不保证这两个操作的先后顺序，也就是说有可能JVM会为新的Singleton实例分配空间，
    //然后直接赋值给instance成员，然后再去初始化这个Singleton实例。这样就可能出错了
//	public static Singleton getInstance(){
//		if(instance == null ){
//			synchronized (Singleton.class) {
//				if(instance == null){
//					instance = new Singleton();
//				}
//			}
//		}
//		return instance;
//	}

    /**
     * 多线程开发中，为了解决并发问题，主要是通过使用synchronized来加互斥锁进行同步控制，
     *   但是在某些情况下，JVM已经隐含的为您执行了同步，这些情况下就不用自己再来进行同步控制了。
     *   这些情况包括：
     *   （1）由静态初始化器（在静态字段上或static{}块中的初始化器）初始化数据时
     *   （2）访问final字段时
     *   （3）在创建线程之前创建对象时
     *   （4）线程可以看见它将要处理的对象时
     */

    /**
     * 要想很简单的实现线程安全，可以采用静态初始化器的方式，它可以由JVM来保证线程的安全性。比如前面的饿汉式实现方式。
     * 但是这样一来，不是会浪费一定的空间吗？因为这种实现方式，会在类装载的时候就初始化对象，不管你需不需要。
     * <p>
     * 如果现在有一种方法能够让类装载的时候不去初始化对象，那不就解决问题了？一种可行的方式就是采用类级内部类，
     * 在这个类级内部类里面去创建对象实例。这样一来，只要不使用到这个类级内部类，那就不会创建对象实例，从而同步实现延迟加载和线程安全。
     */


    public static Singleton getInstance() {
        return SingletonHolder.instance;
    }

    public static void main(String[] args) {
        Singleton.getInstance().sayHello();
    }

    public synchronized void sayHello() {
        System.out.println("hi~");
    }

    //静态内部类
    private static class SingletonHolder {
        private static Singleton instance = new Singleton();
    }

}
