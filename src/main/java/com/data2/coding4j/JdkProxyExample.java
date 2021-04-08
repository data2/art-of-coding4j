package com.data2.coding4j;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyExample {

    //jdk动态代理运用的是java的反射机制，借用的java 代理类Proxy和InvocationHandler处理类，
    //通过method.invoke去动态执行对象的方法，并在前后可以输出日志类似的处理；
    //针对实现接口的类 ： 利用java反射生成一个实现代理接口的匿名类(获取对象的构造器进行实例化) ，在调用具体方法前调用InvokeHandler来处理
    //针对类：cglib（asm字节码增强器 需要依赖cglib类库）- 对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理
    public static void main(String[] args) {
        final People person = new People();
        Eat eat = (Eat)Proxy.newProxyInstance(
                JdkProxyExample.class.getClassLoader(),
                person.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("log proxy, before invoke");
                        return method.invoke(person, args);
                    }
                });
        eat.eat();
    }

}
interface Eat{
    void eat();
}
class People implements Eat{
    public void eat(){
        System.out.println("eat");
    }
}

