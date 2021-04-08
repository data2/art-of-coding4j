package com.data2.coding4j.designpatterns.struts.proxy;
/**
 * 
 * 代理模式（Proxy Pattern），为其它对象提供一种代理以控制对这个对象的访问。
装饰模式（Decorator Pattern），动态地给一个对象添加一些额外的职责。
从语意上讲，代理模式的目标是控制对被代理对象的访问，而装饰模式是给原对象增加额外功能。


 * 代理模式的作用是：为其他对象提供一种代理以控制对这个对象的访问。在某些情况下，一个客户不想或者不能直接引用另一个对象，而代理对象可以在客户端和目标对象之间起到中介的作用。
 * 
 * 利用JDK中的动态代理。利用静态方法Proxy.newInstance(ClassLoader, Interfaces[], InvokeHandler)可以创建一个动态代理类。
 *  newInstance方法有三个参数， 分别表示类加载器， 一个希望该代理类实现的接口列表， 以及实现InvokeHandler接口的实例。 
 *  动态代理将每个方法的执行过程则交给了Invoke方法处理。
 *  
 *  装饰模式的本质是动态组合。动态是手段，组合是目的。每个装饰类可以只负责添加一项额外功能，然后通过组合为被装饰类添加复杂功能。由于每个装饰类的职责比较简单单一，增加了这些装饰类的可重用性，同时也更符合单一职责原则。
 */
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo01 {

	public static void main(String[] args) {
		DriveBus driveBus = new DriveBus();
		DriveHandler handler = new DriveHandler(driveBus);
		Drive drive = (Drive)Proxy.newProxyInstance(
				driveBus.getClass().getClassLoader(), 
				driveBus.getClass().getInterfaces(), 
				handler);
		drive.drive();
	}

}
interface Drive{
	void drive();
} 
class DriveCar implements Drive{

	@Override
	public void drive() {
		System.out.println("drive car");
	}
	
}
class DriveBus implements Drive{

	@Override
	public void drive() {
		System.out.println("drive bus");
	}
	
}
class DriveHandler implements InvocationHandler{
	public Object drive;
	
	public DriveHandler(Drive drive) {
		this.drive = drive;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("before execute");
		Object res = method.invoke(drive, args);
		System.out.println("after execute");
		return res;
	}
	
} 
