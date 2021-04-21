/**
 * FileName:   Map_.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.grammar.collection;

import org.junit.Test;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.TreeMap;

public class Map_ {
    
    
    @Test
    public void testHashMap() {
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("key", "value");
        map.put(null, null);
    }
    
    
    @Test
    public void testTreeMap() {
        TreeMap<String, String> map = new TreeMap<String, String>();
        map.put("b", "b");
        map.put("a", "a");
        map.put("1", "c");
        map.put("A", "A");
        System.out.println(map);
    }
    
    @Test
    public void testIdentityHashMap() {
        IdentityHashMap<String, Object> identity = new IdentityHashMap<String, Object>();
        Object s = "ss";
        identity.put("1", s);
        identity.put("2", s);
        System.out.println(identity.get("1") == identity.get("2"));
        
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("1", s);
        map.put("2", s);
        System.out.println(map.get("1") == map.get("2"));
    }
}
