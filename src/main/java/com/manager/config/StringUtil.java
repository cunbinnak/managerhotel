package com.manager.config;

public class StringUtil {
    public static String checkValidString(String value){
        if(value != null && !value.isEmpty()){
            return value;
        }
        return null;
    }
}
