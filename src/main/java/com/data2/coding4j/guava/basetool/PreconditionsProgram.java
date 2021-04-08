package com.data2.coding4j.guava.basetool;

import org.junit.Test;

/**
 * Created by wanglei on 2016/10/12.
 * 前置条件：让方法调用的前置条件判断更简单。
 */
public class PreconditionsProgram {
    @Test
    public void preconditions(){
        //Preconditions.checkNotNull(null);//空指针异常

        //Preconditions.checkArgument(1 > 2);//IllegalArgumentException
        //Preconditions.checkArgument(1 == 2, "不相等");//IllegalArgumentException: 不相等

    }
}
