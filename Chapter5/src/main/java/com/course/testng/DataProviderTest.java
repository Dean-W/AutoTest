package com.course.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age) {
        System.out.println("name=" + name + ",age=" + age);
    }

    @DataProvider(name = "data")
    public Object[][] providerData() {
        Object[][] o = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 20},
                {"wangwu", 30}
        };
        return o;
    }

    @Test(dataProvider = "methoddata")
    public void test1(String name, int age) {
        System.out.println("test111方法 name=" + name + "，age=" + age);
    }

    @Test(dataProvider = "methoddata")
    public void test2(String name, int age) {
        System.out.println("test111方法 name=" + name + "，age=" + age);
    }

    @DataProvider(name = "methoddata")
    public Object[][] methodDataTest(Method method) {
        Object[][] result = null;
        if (method.getName().equals("test1")) {
            result = new Object[][]{
                    {"张三", 20},
                    {"李四", 25}

            };

        } else if (method.getName().equals("test2")) {
            result = new Object[][]{
                    {"王五", 50},
                    {"赵六", 60}

            };
        }
        return result;


    }
}
