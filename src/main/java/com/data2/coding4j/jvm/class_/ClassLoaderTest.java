/**
 * FileName:   ClassLoaderTest.java
 *
 * @Description 类加载
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.jvm.class_;

import org.junit.Test;

/**
 * 虚拟机把描述类的Class文件加载到内存,并对数据进行校验,解析和初始化,最终形成能被java虚拟机直接使用的java类型,这就是虚拟机的类加载机制.<br/>
 * <br/>
 *
 * 类从加载到虚拟机内存到被从内存中释放,经历的生命周期<br/>
 * 加载- 验证- 准备- 解析- 初始化- 使用- 卸载<br/>
 * <br/>
 * 加载 - 链接 - 初始化- 使用 - 卸载
 *
 * 类加载器的双亲委派模型<br/>
 * 双亲委派模型是一种组织类加载器之间关系的一种规范,他的工作原理是:如果一个类加载器收到了类加载的请求,它不会自己去尝试加载这个类,
 * 而是把这个请求委派给父类加载器去完成,这样层层递进,最终所有的加载请求都被传到最顶层的启动类加载器中,
 * 只有当父类加载器无法完成这个加载请求(它的搜索范围内没有找到所需的类)时,才会交给子类加载器去尝试加载.<br/>
 *
 * 这样的好处是:java类随着它的类加载器一起具备了带有优先级的层次关系.这是十分必要的,
 * 比如java.langObject,它存放在\jre\lib\rt.jar中,它是所有java类的父类,
 * 因此无论哪个类加载都要加载这个类,最终所有的加载请求都汇总到顶层的启动类加载器中,
 * 因此Object类会由启动类加载器来加载,所以加载的都是同一个类,如果不使用双亲委派模型,
 * 由各个类加载器自行去加载的话,系统中就会出现不止一个Object类,应用程序就会全乱了.
 *
 *
 */
public class ClassLoaderTest {

    /**
     * 启动类加载器<br/>
     * 这个类加载器负责将JAVA_HOME/lib目录下的类库加载到虚拟机内存中,用来加载java的核心库<br/>
     * 此类加载器并不继承于java.lang.ClassLoader,不能被java程序直接调用<br/>
     * 代码是使用C++编写的.是虚拟机自身的一部分<br/>
     */
    public void testBootstrapClassLoader() {
    }

    /**
     * 扩展类加载器<br/>
     * 负责加载JAVA_HOME/lib/ext目录下的类库,用来加载java的扩展库<br/>
     */
    @Test
    public void testExtendsionClassLoader() {
    }

    /**
     * 应用程序类加载器<br/>
     * 负责加载用户类路径(CLASSPATH)下的类库<br/>
     * 一般情况下这就是系统默认的类加载器,CLassLoader中的getSystemClassLoader()方法的返回值<br/>
     */
    @Test
    public void testApplicationClassLoader() {
        ClassLoader localLoader = ClassLoaderTest.class.getClassLoader();
        ClassLoader loader = ClassLoader.getSystemClassLoader();
        System.out.println(localLoader.getClass());
        System.out.println(localLoader.getParent());
        System.out.println(loader);
        try {
            System.out.println(ClassLoaderTest.class.getName());
            Class<?> class1 = loader.loadClass(ClassLoaderTest.class.getName());
            System.out.println(class1.getPackage());
            System.out.println(class1.getSuperclass());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * Class.forname():是一个静态方法,最常用的是Class.forname(String className);<br/>
     * 根据传入的类的全限定名返回一个Class对象.该方法在将Class文件加载到内存的同时,会执行类的初始化.<br/>
     * 如: Class.forName("com.wang.HelloWorld");<br/>
     * ClassLoader.loadClass():这是一个实例方法,需要一个ClassLoader对象来调用该方法<br/>
     * 该方法将Class文件加载到内存时,并不会执行类的初始化,直到这个类第一次使用时才进行初始化.<br/>
     * 该方法因为需要得到一个ClassLoader对象,所以可以根据需要指定使用哪个类加载器.<br/>
     * 如:ClassLoader cl=.......;cl.loadClass("com.wang.HelloWorld");<br/>
     */
    @Test
    public void testClassForName() {
        try {
            Class.forName(ClassLoaderTest.class.getName());// 默认初始化这个类
            Class.forName(ClassLoaderTest.class.getName(), false, ClassLoader.getSystemClassLoader());// 可以指定不初始化
            ClassLoader.getSystemClassLoader().loadClass(ClassLoaderTest.class.getName());// 不会初始化类
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
