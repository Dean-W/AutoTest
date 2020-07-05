package com.course.httpclient.cookies;

import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiessForGet {

    private String url;//存放域名
    private ResourceBundle bundle;//获取配置文件的对象
    private CookieStore store;//存储cookie信息
    String testUrl;//存放拼接域名


    @BeforeTest
    public void  beforeTest(){
        bundle=ResourceBundle.getBundle("application", Locale.CHINA);//getBundle自动识别，properties文件，所以获取配置文件，application是配置文件名，不用加文件类型
        /* 获取配置文件中的url */
        url=bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        String uri=bundle.getString("getCookies.uri");
        String testUrl=this.url+uri;//从配置文件中拼接url
        System.out.println(testUrl);
        HttpGet get= new HttpGet(testUrl);
        //HttpClient client=new DefaultHttpClient();
        DefaultHttpClient client=new DefaultHttpClient();//DefaultHttpClient有获取cookies信息方法
        HttpResponse response = client.execute(get);
        result = EntityUtils.toString(response.getEntity());
        System.out.println(result);

        //获取cookies信息
        this.store=client.getCookieStore();
        List<Cookie> cookieList=store.getCookies();//这一句是什么意思

        //答应获取的cookiename和cookievalue
        for (Cookie cookie:cookieList){
            String name=cookie.getName();
            String value=cookie.getValue();
            System.out.println("cookiesname="+name+",cookiesvalue="+value);

        }
    }
    //带上cookies进行下面操作 9-5课程内容
    @Test(dependsOnMethods = {"testGetCookies"})
    public void testWithCookies ()throws IOException{
        String uri=bundle.getString("test.get.with.cookies");
        testUrl=this.url+uri;
        HttpGet get=new HttpGet(testUrl);
        System.out.println(testUrl);
        DefaultHttpClient client=new DefaultHttpClient();

        client.setCookieStore(this.store);

        HttpResponse response= client.execute(get);

        //获取响应的状态码
        int statusCode=response.getStatusLine().getStatusCode();
        System.out.println("statusCode="+statusCode);

        if (statusCode==200){
            String result=EntityUtils.toString(response.getEntity());
            System.out.println(result);
        }

        }


    }

