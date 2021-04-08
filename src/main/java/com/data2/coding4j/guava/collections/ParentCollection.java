package com.data2.coding4j.guava.collections;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by wanglei on 2016/10/10.
 * 集合父类（工具类）
 */
public class ParentCollection implements LoggerInterface {
    public void printLog(Object obj) {
        System.out.println(obj.toString());
    }

    public void printLog(String obj) {
        System.out.println(obj);
    }

    public void printLog(List<?> list) {
        printLog((Collection<?>) list);
    }

    public void printLog(Set<?> set) {
        printLog((Collection<?>) set);
    }

    public void printLog(Map<?, ?> map) {
        Iterator<?> it = map.entrySet().iterator();
        while (it.hasNext()) {
            Entry<?, ?> entry = (Entry<?, ?>) it.next();
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public void printLog(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            System.out.println((it.next()).toString());
        }
    }
}
