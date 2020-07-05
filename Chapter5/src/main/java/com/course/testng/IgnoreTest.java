package com.course.testng;

import org.testng.annotations.Test;
/*
忽略测试，应用场景：在执行用例过程中，某些测试方法不执行时，可以用这个进行属性进行控制
 */

public class IgnoreTest {

    @Test
    public void ignore1(){
        System.out.println("ignore1 执行");
    }

    @Test(enabled = false)
    public void ignore2(){
        System.out.println("ignore2 执行");
    }

    @Test(enabled = true)
    public void ignore3(){
        System.out.println("ignore3 执行");
    }
}
