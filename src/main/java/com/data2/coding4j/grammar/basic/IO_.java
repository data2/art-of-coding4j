package com.data2.coding4j.grammar.basic;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

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
