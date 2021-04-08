package com.data2.coding4j.guava.collections.googleguava.factory;

import com.google.common.base.Preconditions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by wanglei on 2016/10/12.
 */
public final class MuskteerLists {

    @SuppressWarnings("unchecked")
    public static <E> ArrayList<E> newArrayList(E... elements) {
        Preconditions.checkNotNull(elements);
        ArrayList<E> list = new ArrayList<E>(100);
        Collections.addAll(list, elements);
        return list;
    }

    public static <E> ArrayList<E> newArrayListWithCapacity(int capacity) {
        Preconditions.checkNotNull(Math.abs(capacity));
        return new ArrayList<E>(Math.abs(capacity));
    }

    @SuppressWarnings("unchecked")
    public static <C> List<List<C>> newDouble(List<? extends List<? extends C>> list) {
        return (List<List<C>>) list;
    }

    public <D> void tt(D t){
        @SuppressWarnings("unused")
        Class<? extends Object> cls = t.getClass();
    }


}
