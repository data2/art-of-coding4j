package com.data2.coding4j.designpatterns.struts.decorator;

import com.data2.coding4j.designpatterns.struts.decorator.impl.CeilDecorator;
import com.data2.coding4j.designpatterns.struts.decorator.impl.FloorDecorator;

import java.io.FileNotFoundException;

/**
 * 装饰器模式 _主要用于为对象动态的添加功能_。
 * <p>
 * 在学习 Java IO 的时候，记得头几回看到下面的代码，总是有点纳闷：
 * InputStream inputStream = new BufferedInputStream(new FileInputStream(filePath));
 * <p>
 * <p>
 * 装饰模式能够实现动态的为对象添加功能，是从一个对象外部来给对象添加功能。
 * 通常给对象添加功能，要么直接修改对象添加相应的功能，要么派生对应的子类来扩展，抑或是使用对象组合的方式。
 * 显然，直接修改对应的类这种方式并不可取。在面向对象的设计中，而我们也应该尽量使用对象组合，而不是对象继承来扩展和复用功能。
 * 装饰器模式就是基于对象组合的方式，可以很灵活的给对象添加所需要的功能。装饰器模式的本质就是动态组合。动态是手段，组合才是目的。
 * 总之，装饰模式是通过把复杂的功能简单化，分散化，然后再运行期间，根据需要来动态组合的这样一个模式。
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Decorator d =
                new FloorDecorator(
                        new CeilDecorator(
                                new House()));
        d.decorate();

//		BufferedWriter bw = 
//		     new BufferedWriter(
//		        new OutputStreamWriter(
//		            new FileOutputStream(
//		               new File("tx.txt"))));
    }

}
