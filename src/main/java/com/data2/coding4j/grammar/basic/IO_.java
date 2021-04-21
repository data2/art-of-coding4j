package com.data2.coding4j.grammar.basic;

import org.junit.Test;

import java.io.*;

/**
 * 
 *
 */
public class IO_ {

    @Test
    public void testBufferedReader() throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(new File("a.txt")));
        br.close();

        InputStreamReader r = new InputStreamReader(new FileInputStream(new File("a.txt")), "UTF-8");
        r.close();

        InputStreamReader r1 = new InputStreamReader(new FileInputStream("a.txt"));
        r1.close();

    }
}
