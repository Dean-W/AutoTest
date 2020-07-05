package com.course.testng.parameter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static java.lang.System.out;

public class ParameterTest {

    //数据来自xml文件参数化例子
    @Test
    @Parameters({"name","age"})
    public  void paramTest1(String name,int age){
        out.println("name= "+name+"，age="+age);
    }
}
