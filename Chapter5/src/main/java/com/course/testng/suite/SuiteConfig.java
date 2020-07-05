package com.course.testng.suite;

import org.testng.annotations.*;
import sun.management.snmp.jvmmib.JVM_MANAGEMENT_MIBOidTable;

/*
进行所有测试套件的配置
 */
public class SuiteConfig {
    @BeforeSuite
    public void beforeSuite(){
        System.out.println("before suite运行啦");
    }

    @AfterSuite
    public void  afterSuite(){
        System.out.println("aftersuite运行啦");
    }
    @BeforeTest
    public void beforeTest(){
        System.out.println("boforetest");
    }

    @AfterTest
    public void  afterTest() {
        System.out.println("aftertest");
    }
}
