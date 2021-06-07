package com.data2.coding4j.designpatterns.action.observer;
/**
 * 观察者与被观察者之间是属于轻度的关联关系，并且是抽象耦合的，这样，对于两者来说都比较容易进行扩展。
 * <p>
 * 观察者模式是一种常用的触发机制，它形成一条触发链，依次对各个观察者的方法进行处理。但同时，这也算是观察者模式一个缺点，
 * 由于是链式触发，当观察者比较多的时候，性能问题是比较令人担忧的。并且，在链式结构中，比较容易出现循环引用的错误，造成系统假死。
 */

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Vector;

/**
 * @author leewow
 */
public class TestObserver{
    public static void main(String[] args) {
        Machine1 machine = new Machine1();
        machine.addObserver(new Email1());
        machine.addObserver(new WeixinMsg1());
        machine.doSomething();
    }
}

abstract class Subject {
    private List<Observer> obs = Lists.newArrayList();

    public void addObserver(Observer obs) {
        this.obs.add(obs);
    }

    public void delObserver(Observer obs) {
        this.obs.remove(obs);
    }

    protected void notifyObserver() {
        for (Observer o : obs) {
            o.update();
        }
    }

    public abstract void doSomething();
}

class Machine1 extends Subject {
    @Override
    public void doSomething() {
        System.out.println("主机异常");
        this.notifyObserver();
    }
}

/**
 * 观察者
 */
interface Observer {
    public void update();
}

class Email1 implements Observer {
    @Override
    public void update() {
        System.out.println("邮件告警");
    }
}

class WeixinMsg1 implements Observer {
    @Override
    public void update() {
        System.out.println("微信告警");
    }
}

