package com.course.testng;

import org.testng.annotations.Test;
/*
依赖测试的场景：一个方法失败后，接下来就不会执行
购物流程；登录失败了，就不会进行一个购买的操作
 */

public class DependTest {

    @Test
    public void test1() {
        System.out.println("test1 run");
        throw new RuntimeException();
    }

    @Test(dependsOnMethods = {"test1"})
    public void test2() {
        System.out.println("test2 run");
    }
}
