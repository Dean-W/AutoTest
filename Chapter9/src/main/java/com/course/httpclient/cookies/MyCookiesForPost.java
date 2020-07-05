package com.course.httpclient.cookies;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {

    private ResourceBundle bundle;//获取配置文件对象
    public String url;//用来保存域名url
    private CookieStore store;


    @BeforeTest
    public void beforeTest(){
        //获取配置文件
         bundle=ResourceBundle.getBundle("application", Locale.CHINA);
        //获取配置文件中的配置
         url=bundle.getString("test.url");
        System.out.println(url);
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        //获取cookies信息uri
        String uri=bundle.getString("getCookies.uri");
        //拼接url+uri
        String testUrl=this.url+uri;
        System.out.println(testUrl);
        //将拼接的url封装成一个get请求
        HttpGet get=new HttpGet(testUrl);
        //发送testUrl请求
        DefaultHttpClient client=new DefaultHttpClient();
        //发送请求
        HttpResponse response = client.execute(get);
        //将返回结果，转为String
        result = EntityUtils.toString(response.getEntity());
        //打印结果
        System.out.println(result);
        //获取当前页面的cookie
         store=client.getCookieStore();
        //获取之后再把它封装到cookie的list里面去
        List<Cookie> cookieList=store.getCookies();
        //下面这个for循环好好理解一下
        for(Cookie cookie:cookieList){//实例化一个cookie对象，比例容器对象对象里面的值
            String name= cookie.getName();
            String value= cookie.getValue();
            System.out.println("cookiename="+name+"，value="+value);
        }

    }


        @Test(dependsOnMethods = "testGetCookies")
    public void testPostMethod() throws IOException {
            String uri=bundle.getString("test.post.with.cookies");

            //uri拼接
            String testUrl=this.url+uri;

            HttpPost post;
            post = new HttpPost(testUrl);
            //添加json请求
            JSONObject param=new JSONObject();
            param.put("name","huhansan");//添加了json请求的两个参数
            param.put("age","18");

            //设置请求头信息
            post.setHeader("content-ype","application/json");
            System.out.println(Header.class);
            //放置参数信息
            StringEntity entity=new StringEntity(param.toString(),"utf-8");
            post.setEntity(entity);
            //实例化一个客户端对象
            DefaultHttpClient client=new DefaultHttpClient();
            //将以上获取的cookie值放到cookie项里面
            client.setCookieStore(this.store);


            HttpResponse response= client.execute(post);

            String result = EntityUtils.toString(response.getEntity());

            System.out.println(result);

            //实例化JSONObject对象，将返回的json格式结果放进去
            JSONObject resultjson= new JSONObject(result);
            //将JSONObject对象的值取出来
            String success=(String) resultjson.get("huhansan");
            String status=(String) resultjson.get("status");
            //判断返回结果判断
            Assert.assertEquals("success",success);
            Assert.assertEquals("1",status);

        }




}
