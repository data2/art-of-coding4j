package com.data2.coding4j.grammar.basic;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Test;

/**
 * Java异常的基类为java.lang.Throwable<br/>
 * java.lang.Error和java.lang.Exception继承 Throwable<br/>
 * RuntimeException和其它的Exception等继承Exception<br/>
 * <hr/>
 * Error和RuntimeException 及其子类都是未检查的异常（unchecked exceptions）<br/>
 * 所有其他的Exception类都是检查了的异常（checked exceptions）<br/>
 * <br/>
 * 1.检查了的异常发生在编译阶段，必须要使用try…catch（或者throws）否则编译不通过。 <br/>
 * 比如FileNotFoundException, ParseException等<br/>
 * <br/>
 * 2.未检查的异常发生在运行期，具有不确定性，主要是由于程序的逻辑问题所引起的。<br/>
 * 比如ArrayIndexOutOfBoundException, ClassCastException等<br/>
 * 然能够从诸如RuntimeException这样的异常中catch并恢复，但是并不鼓励终端程序员这么做，因为完全没要必要。因为这类错误本身就是bug，
 * 应该被修复，出现此类错误时程序就应该立即停止执行<br/>
 * 面对Errors和unchecked
 * exceptions应该让程序自动终止执行，程序员不该做诸如try/catch这样的事情，而是应该查明原因，修改代码逻辑。
 * 
 * 
 * 
 *
 */
public class Exception_ {

    @Test
    public void test() {
        calDivide(1, 0);
    }

    private int calDivide(int i, int j) {
        try {
            return i / j;
        } catch (Exception e) {
            System.out.println("exception");
        }
        return 0;

    }

    public static void main(String[] args) {
        try {
            throw new IOException();
        } catch (FileNotFoundException ex) {
            System.out.print("FileNotFoundException!");
        } catch (IOException ex) {
            System.out.print("IOException!");
        } catch (Exception ex) {
            System.out.print("Exception!");
        }
    }
}
