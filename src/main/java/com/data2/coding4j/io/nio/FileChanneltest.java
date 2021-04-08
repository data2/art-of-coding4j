/**
 * FileName:   NIOTest.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.io.nio;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wanglei
 *
 */
public class FileChanneltest {

    /**
     * FileChannel不可以设置为非阻塞模式，他只能在阻塞模式下运行。
     */
    public static void main(String[] args) {
        RandomAccessFile file = null;
        try {
            file = new RandomAccessFile(new File("NIOTEST.txt"), "rw");
            FileChannel channel = file.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(6);
            int i = channel.read(buffer);
            while(i != -1){
                buffer.flip();
                while(buffer.hasRemaining()){
                    System.out.println((char)buffer.get());
                }
                buffer.clear();
                i = channel.read(buffer);
            }
        } catch (Exception e) {
        } finally{
            try {
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
