package com.data2.coding4j.grammar.basic;

import org.junit.Test;

/**
 * String s = new String("abc");
 * 
 * String s = new String("abc")中的"abc"会先在对象池中查找是否存在值为"abc"的对象，没有则创建一个；
 * 其二，Java基础中有讲凡是遇到new关键字就会申请内存空间创建对象，所以new又创建了一个值为"abc"的对象，
 * 而s仅仅是一个引用而已，它不是对象，它指向new创建出来的"abc"对象的内存地址，该对象是在内存堆中的，而不是对象池中。
 * 
 * String是不可变(final)类，每次在String对象上的操作都会生成一个新的对象；
 * StringBuffer和StringBuilder是可变的，它允许在原来对象上进行操作，而不用每次增加对象；
 * StringBuffer是线程安全的，但效率较低，而StringBuilder则不是线程安全的，效率最高。
 */
public class StringTest {

    @Test
    public void testAddr() {
        String str = "hello";
        String str_a = "he" + new String("llo");
        System.out.println(str == str_a);
        // 因为str2中的llo是新申请的内存块，而==判断的是对象的地址而非值，所以不一样
    }

    @Test
    public void testString() {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program" + "ming";
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//true
        System.out.println(s1 == s1.intern());////true
        // String对象的intern方法会得到字符串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与String对象的equals结果是true），
        // 如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用。

        String ss = new String("abc");
        String ss1 = "abc";
        String ss2 = new String("abc");
        System.out.println(ss == ss1.intern());//false
        System.out.println(ss == ss2.intern());//false
        System.out.println(ss1 == ss2.intern());//true
    }

    @Test
    public void testString2() {
        String s1 = "ab";
        String s2 = "cd";
        String s3 = "ab" + "cd";
        String s4 = s1 + s2;
        String s5 = new String("ab") + new String("cd");
        String s6 = new String("ab") + "cd";
        String s7 = s1 + "cd";
        String s8 = new String("ab") + s2;

        String s = "abcd";

        System.out.println(s3 == s);// true
        System.out.println(s4 == s);// false
        System.out.println(s5 == s);// false
        System.out.println(s6 == s);// false
        System.out.println(s7 == s);// false
        System.out.println(s8 == s);// false

        // 只需记住“+”号两边只要有非对象池中的字符串对象那么必然会在内存中创建新对象
        // 只有在“+”号两侧对象都是字面上的字符串时才会从池子中查找，如：s3 = "ab" +
        // "cd"，“+”号两侧的对象都是对象池中的对象，二者拼接后依旧在对象池中查找。
    }

    // public static void main(String[] args){ String a = "a1"; String b = "a"+
    // 1; System.out.println(a==b); }//true
    // public static void main(String[] args){ String a = "ab"; String bb = "b";
    // String b = "a"+ bb; System.out.println(a==b);}//false
    // public static void main(String[] args){ String a = "ab"; final String bb
    // = "b"; String b = "a"+ bb; System.out.println(a==b); }//true

    @Test
    public void testString3() {
        String str1 = "hello";
        str1.concat(" world");// 因为String是不可变(final)的，所以输出为”hello”
        System.out.println(str1); // hello
    }

    /**
     * 
     解释内存中的栈(stack)、堆(heap)和静态区(static area)的用法。
     * 答：通常我们定义一个基本数据类型的变量，一个对象的引用，还有就是函数调用的现场保存都使用内存中的栈空间；
     * 而通过new关键字和构造器创建的对象放在堆空间； 程序中的字面量（literal）如直接书写的100、"hello"和常量都是放在静态区中。
     * 
     * 栈空间操作起来最快但是栈很小， 通常大量的对象都是放在堆空间，
     * 理论上整个内存没有被其他进程使用的空间甚至硬盘上的虚拟内存都可以被当成堆空间来使用。
     */
    @Test
    public void testName() {
        @SuppressWarnings("unused")
        String str = new String("hello");
        // 上面的语句中变量str放在栈上，用new创建出来的字符串对象放在堆上，而"hello"这个字面量放在静态区。
    }

    @Test
    public void testReverse() {
        System.out.println(reverseStr("abcd"));
    }

    private String reverseStr(String string) {
        if (string.length() == 0) {
            return string;
        }
        String s = reverseStr(string.substring(1)) + string.charAt(0);
        System.out.println(s);
        return s;
    }
    
    @Test
    public void test8(){
        String s1 = "abcdef";  
        String s2 = "abcdef";  
        String s3 = "abc"+"def";//编译期自动优化为String s3 = "abcdef";  
        System.out.println(s1 == s2);//true  
        System.out.println(s1 == s3);  //true
        System.out.println(s2 == s3); //true
    }
    
    @Test
    public void test9(){
        String s1 = "abc";
        String s2 = "abcdef";
        String s3 = "abc"+"def";  
        String s4 = s1 + "def";  
        System.out.println(s2 == s3); //true 编译器优化
        System.out.println(s2 == s4);  //false 编译器无法优化
    }
    
    @Test
    public void testEnd(){
        String s1 = new String("abc");
        String s2 = "abc";
        String s3 = new String("abc");
    
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s3);//false
        System.out.println(s2 == s3);//false
    
        System.out.println(s1 == s1.intern()); //false
        System.out.println(s2 == s2.intern());// true
        System.out.println(s1.intern() == s2.intern());//true    
    
        String hello = "hello";
        String hel = "hel";
        String lo = "lo";
    
        System.out.println(hello == "hello");//true  
        System.out.println(hello == "hel" + "lo");//true
        System.out.println(hello == "hel" + lo);//false   
        System.out.println(hello == hel + lo);//false  
    }
    
}
