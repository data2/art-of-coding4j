package com.data2.coding4j.grammar.collection;

import org.junit.Test;

import java.util.*;

/**
 * List是有序的Collection，使用此接口能够精确的控制每个元素插入的位置。<br/>
 * 实现List接口的常用类有LinkedList，ArrayList，Vector和Stack。<br/>
 * <br/>
 * LinkedList实现了List接口，允许null元素。<br/>
 * <br/>
 * ArrayList实现了可变大小的数组。它允许所有元素，包括null。<br/>
 * <br/>
 * 和LinkedList一样，ArrayList也是非同步的（unsynchronized）。<br/>
 * <br/>
 * Vector非常类似ArrayList，但是Vector是同步的,
 * 调用Iterator的方法进行多线程修改时将抛出ConcurrentModificationException，因此必须捕获该异常。<br/>
 * <br/>
 * Stack继承自Vector，实现一个后进先出的堆栈<br/>
 * <br/>
 * <hr/>
 * Set是一种不包含重复的元素的Collection，即任意的两个元素e1和e2都有e1.equals(e2)=false，Set最多有一个null元素。
 * <br/>
 * <hr/>
 * Map没有继承Collection接口<br/>
 * Hashtable继承Map接口，实现一个key-value映射的哈希表。任何非空（non-null）的对象都可作为key或者value。<br/>
 * <br/>
 * Hashtable是同步的。<br/>
 * <br/>
 * HashMap和Hashtable类似，不同之处在于HashMap是非同步的，并且允许null，即null value和null key。<br/>
 * <br/>
 * <p>
 * <hr/>
 * 如果涉及到堆栈，队列等操作，应该考虑用List，对于需要快速插入，删除元素，应该使用LinkedList，如果需要快速随机访问元素，
 * 应该使用ArrayList<br/>
 * <br/>
 * 如果程序在单线程环境中，或者访问仅仅在一个线程中进行，考虑非同步的类，其效率较高，如果多个线程可能同时操作一个类，应该使用同步的类。<br/>
 * <br/>
 * 尽量返回接口而非实际的类型，如返回List而非ArrayList，这样如果以后需要将ArrayList换成LinkedList时，客户端代码不用改变。
 * 这就是针对抽象编程。<br/>
 */
public class Collection_ {

    @Test
    @SuppressWarnings("unused")
    public void testCollection() {
        Collection<Object> c = new Vector<Object>();
    }

    @Test
    @SuppressWarnings("unused")
    public void testSet() {
        Set<String> set = new TreeSet<String>();
        set = new HashSet<String>();
        set = new LinkedHashSet<String>();
    }

    @Test
    @SuppressWarnings("unused")
    public void testQueue() {
        Queue<String> q = new PriorityQueue<String>();
        Deque<String> d = new LinkedList<String>();
    }

    @Test
    @SuppressWarnings("unused")
    public void testList() {
        List<String> list = new ArrayList<String>();
        list = new LinkedList<String>();
        list = new Vector<String>();
        list = new Stack<String>();

        LinkedList<String> linkedList = new LinkedList<String>();
        ListIterator<String> it = linkedList.listIterator();//可以向前 或者 向后遍历

        Vector<String> v = new Vector<String>();

        Stack<String> stack = new Stack<String>();
        System.out.println(stack.size());
        stack.push("sd");
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }

}
