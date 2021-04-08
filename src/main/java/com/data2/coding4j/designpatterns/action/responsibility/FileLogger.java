/**
 * FileName:   FileLogger.java
 * @Description TODO
 * All rights Reserved, Code by Muskteer
 * Copyright MuskteerAthos@gmail.com
 * @author MuskteerAthos
 */
package com.data2.coding4j.designpatterns.action.responsibility;

/**
 * @author wanglei
 *
 */
public class FileLogger extends AbstractLogger {

    public FileLogger(int level){
       this.level = level;
    }

    @Override
    protected void write(String message) {        
       System.out.println("File::Logger: " + message);
    }
 }