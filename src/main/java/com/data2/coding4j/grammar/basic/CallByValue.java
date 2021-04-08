package com.data2.coding4j.grammar.basic;

/**
 * call by value 。按值传递
 * 
 * @author wanglei
 *
 */
public class CallByValue {
    String str = new String("good");
    char[] ch = { 'a', 'b', 'c' };

    public static void main(String[] args) {
        CallByValue ex = new CallByValue();
        ex.change(ex.str, ex.ch);
        System.out.print(ex.str + " and ");
        System.out.print(ex.ch);
    }

    public void change(String str, char ch[]) {
        str = "test ok";
        ch[0] = 'g';
    }

}
