package com.data2.coding4j.guava.collections;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by wanglei on 2016/10/10.
 */
public interface LoggerInterface {
    void printLog(Object obj);

    void printLog(String str);

    void printLog(List<?> list);

    void printLog(Set<?> set);

    void printLog(Map<?, ?> map);

    void printLog(Collection<?> collection);

}
