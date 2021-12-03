package com.data2.coding4j;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author leewow
 * @description
 * @date 2020/9/3 下午10:04
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ThreadLocalTest {
    @Test
    public void run() {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set(null);
        threadLocal.get();
    }
}
