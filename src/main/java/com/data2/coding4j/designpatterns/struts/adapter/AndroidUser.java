package com.data2.coding4j.designpatterns.struts.adapter;
/**
 * 
 * 适配器模式将一个类的接口转换成客户期望的另一个接口，让原本不兼容的接口可以合作无间。
 * 
适配器模式的三个特点：
1 适配器对象实现原有接口
2 适配器对象组合一个实现新接口的对象（这个对象也可以不实现一个接口，只是一个单纯的对象）
3 对适配器原有接口方法的调用被委托给新接口的实例的特定方法

这就是适配器模式的魅力：不改变原有接口，却还能使用新接口的功能。

1 适配器必须实现原有的旧的接口
2 适配器对象中持有对新接口的引用，当调用旧接口时，将这个调用委托给实现新接口的对象来处理，也就是在适配器对象中组合一个新接口。
 */
import com.data2.coding4j.designpatterns.struts.adapter.impl.IosChargeImpl;

public class AndroidUser {
	
	private AndroidCharger androidCharger;
	
	public AndroidUser(AndroidCharger androidCharger) {
		this.androidCharger = androidCharger;
	}
	
	public void charge() {
		androidCharger.charge();
	}
	
	
	public static void main(String[] args) {
//		用户没有使用ios设备充电器的需求之前
//		AndroidCharger androidCharger = new AndroidChargeImpl();
//		AndroidUser user = new AndroidUser(androidCharger);
//		user.charge();
		
		//切换ios充电器
		IosCharger iosCharger = new IosChargeImpl();
		Adapter adapter = new Adapter(iosCharger);
		AndroidUser user = new AndroidUser(adapter);
		user.charge();
	}
}
