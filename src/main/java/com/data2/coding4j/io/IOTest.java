/**
 * FileName:   ioTest.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.io;

import java.io.*;

/**
 * @author wanglei
 *
 */
public class IOTest {

    /**
     * @param args
     * @throws FileNotFoundException 
     */
    public static void main(String[] args){
        //RANDOM ACCESS
        RandomAccessFile rFile = null;
        try {
            rFile = new RandomAccessFile(new File("IOTEST.txt"),"rw");
            rFile.seek(1);
            String tmp = null;
            if((tmp = rFile.readLine()) != null){
                System.out.println(tmp);
            }
        } catch (Exception e) {
        } finally{
            try {
                rFile.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        //os writer
        OutputStreamWriter ow = null;
        try {
            ow = new OutputStreamWriter(new FileOutputStream(new File("NIOTEST.txt")));
            ow.write("我爱你王肖俊");
            ow.flush();
        } catch (Exception e) {
        } finally{
            try {
                ow.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        
        //writer
        BufferedWriter rw = null;
        try {
            rw = new BufferedWriter(
                new OutputStreamWriter(
                      new FileOutputStream(new File("IOTEST.txt"))));
            rw.write("Java Io");
//            rw.flush();
        } catch (Exception e) {
        } finally{
            try {
                rw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
