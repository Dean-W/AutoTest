package com.course.testng;

import org.testng.annotations.*;

public class BasicAnnotation {

    @Test
    public void testCase1(){
        System.out.print("Test这是测试用例1");

    }

    @Test
    public void testCase2(){
        System.out.print("Test这是测试用例2");

    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("beforemethod是在测试方法之前运行");
    }
    @AfterMethod
    public  void afterMethod(){
        System.out.println("AfterMethod这是在测试方法之后运行的");

    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BeforeClass在类运行之前运行的方法");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AfterClass在类运行之后运行的方法");
    }

    @BeforeSuite
    public void beforeSuit(){
        System.out.println("BeforeSuit测试套件");
    }

    public void afterSuit(){
        System.out.println("AfterSuit测试套件");
    }
}
