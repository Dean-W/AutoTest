package com.course.testng.multiThread;

import org.testng.annotations.Test;

import java.io.PrintStream;

@Test(invocationCount = 10,threadPoolSize = 3)
public class MultiThreadOnAnnotion {

    public void test(){
        System.out.println(1);
        System.out.printf("Thread Id:%s%n", Thread.currentThread().getId());
    }
}
