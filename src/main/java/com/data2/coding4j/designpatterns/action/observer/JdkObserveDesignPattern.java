package com.data2.coding4j.designpatterns.action.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * jdk自带观察者模式
 *
 * @author leewow
 */
public class JdkObserveDesignPattern {
    public static void main(String[] args) {
        Machine machine = new Machine();
        machine.addObserver(new Email("邮件告警"));
        machine.addObserver(new WeixinMsg("微信告警消息"));
        machine.except();
    }
}

/**
 * 被观察者
 */
class Machine extends Observable {

    public void except() {
        System.out.println("主机异常");
        this.setChanged();
        this.notifyObservers();
    }

}

/**
 * 观察者
 */
class Email implements Observer {

    private String name;

    public Email(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " 发送邮件 ");
    }

}

class WeixinMsg implements Observer {

    private String name;

    public WeixinMsg(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println(name + " 发送消息 ");
    }

}
