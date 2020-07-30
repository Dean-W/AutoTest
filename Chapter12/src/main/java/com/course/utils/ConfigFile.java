package com.course.utils;

import com.course.model.InterfaceName;

import java.util.Locale;
import java.util.ResourceBundle;
/*
拼接url的工具类
 */
public class ConfigFile {
    public static ResourceBundle bundle = ResourceBundle.getBundle("application", Locale.CHINA);

    public static String getUrl(InterfaceName name){
        String address = bundle.getString("test.url");

        String uri="";

        String testUrl;//最终的url

        if ( name == InterfaceName.GETUSERLIST ){
            uri = bundle.getString("getUserList.uri");
        }

        if( name == InterfaceName.LOGIN ){
            uri = bundle.getString("login.uri");
        }

        if ( name ==InterfaceName.ADDUSERINFO ){
            uri = bundle.getString("addUser.uri");
        }

        if ( name ==InterfaceName.GETUSERINFO){
            uri = bundle.getString("getUserInfo.uri");
        }

        if ( name == InterfaceName.UPDATEUSERINFO){
            uri =bundle.getString("updateUserInfo.uri");
        }

        testUrl = address + uri;
        return testUrl;
    }
}
