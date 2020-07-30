package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@RestController
@Api(value = "/",description = "这是我全部的get方法")
public class MyGetMethod {
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "通过这个方法可以获取cookies",httpMethod = "GET")
    public String getCookies(HttpServletResponse response){
        //HttpServerletRequest 装请求信息的类
        //HttpServerletRespouse 装返回信息的类
        Cookie cookie=new Cookie("login","true");
        response.addCookie(cookie);

        return "恭喜你获得cookies信息成功";
}

/*
要求客户端携带cookies访问
 这是一个需要携带cookies信息才能访问的
  */
    @RequestMapping(value = "/get/with/cookies",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带cookies才能访问的get方法",httpMethod = "GET")
    public String getWithCookies(HttpServletRequest request){
        Cookie[] cookies=request.getCookies();
        if (Objects.isNull(cookies)){
            return "你必须携带cookies信息";
        }
        for (Cookie cookie:cookies){
            if (cookie.getName().equals("login")&&cookie.getValue().equals("true")){
                return "恭喜你访问成功";
            }
        }
        return "你必须携带cookies信息";
    }
    /*
        开发一个需要携带参数才能访问的get请求
        第一种实现方式 url：key=value&key=value
        模拟获取商品列表
    */

    @RequestMapping(value = "/get/with/param",method = RequestMethod.GET)
    @ApiOperation(value = "需要携带参数才能访问的get方法",httpMethod = "GET")
    public Map<String,Integer> getList(@RequestParam Integer start,
                                       @RequestParam Integer end)//实际运用场景是去数据库里面取值
        {
        Map<String,Integer> mylist= new HashMap<>();
        mylist.put("鞋",400);
        mylist.put("干脆面",1);
        mylist.put("衬衫",300);

    return mylist;
        }
    /*
        开发一个需要携带参数才能访问的get请求
        第二种实现方式：url:ip:port/get/with/param/10/20
        模拟获取商品方式
    */
    @RequestMapping(value = "/get/with/param/{start}/{end}",method = RequestMethod.GET)
    @ApiOperation(value = "这是需要携带参数才能访问的get方法第二种方式",httpMethod = "GET")
    public Map<String,Integer> myGetList(@PathVariable Integer start,
                                     @PathVariable Integer end)

    {
        Map<String,Integer> myList = new HashMap<>();
        myList.put("鞋",400);
        myList.put("干脆面",1);
        myList.put("衬衫",300);
        return myList;
    }

    }
