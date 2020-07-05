package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;
/*
关于groups的方法的注解
学到关于groups在方法上的将方法执行组进行进行一个分组执行
 */
public class GroupsOnMethod {
    @Test(groups = "server")
    public void test1(){
        System.out.println("这是服务端组的测试方法1111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组的测试方法2222");
    }

    @Test(groups = "client")
    public void test3() {
        System.out.println("这是客户端组的测试方法3333");
    }

    @Test(groups = "client")
    public void test4() {
        System.out.println("这是客户端组的测试方法3333");
    }

    @BeforeGroups("server")
    public void  test5(){
        System.out.println("在服务端组运行之前运行的方法");
    }

    @AfterGroups("server")
    public void  test6(){
        System.out.println("在服务端组运行之后的方法");
    }
}
