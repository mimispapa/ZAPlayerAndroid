package com.cn.zaplayer.util;


import com.google.gson.Gson;

import org.xmlpull.v1.XmlPullParserFactory;

import java.util.HashMap;

import cn.hutool.json.JSONObject;
import cn.hutool.json.XML;

public class RequestUtil {
    private static Gson G_SON;
    static {
        G_SON = new Gson();
    }

    public static HashMap<String,Object> videoListParams(){
        HashMap<String, Object> params = new HashMap<>();
        params.put("ac", "videolist");
        return params;
    }

    public static <T> T parseToJson(String xml, Class<T> clz){
        JSONObject object = XML.toJSONObject(xml);
        String jsonData = object.toString();
        String jsonObject = jsonData.substring(jsonData.indexOf(":")+1, jsonData.length()-1);
        return G_SON.fromJson(jsonObject,clz);
    }

}



