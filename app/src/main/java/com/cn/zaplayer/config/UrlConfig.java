package com.cn.zaplayer.config;

import android.content.Context;

import com.cn.zaplayer.entity.BaseUrlEntity;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class UrlConfig {
    private static List<BaseUrlEntity> URL_LIST = new ArrayList<>();
    public static void load(Context context) {
        try {
            InputStream assets = context.getAssets().open("sources.json");
            //获取文件的字节数
            int lenght = assets.available();
            //创建byte数组
            byte[] buffer = new byte[lenght];
            //将文件中的数据写入到字节数组中
            assets.read(buffer);
            assets.close();
            String result = new String(buffer);
            setupList(result);

        } catch (Exception e) {
        }
    }

    private static void setupList(String string) {
        JsonParser jp = new JsonParser();
        JsonArray jsonArray = jp.parse(string).getAsJsonArray();

        Iterator<JsonElement> iter = jsonArray.iterator();
        while (iter.hasNext()) {
            JsonObject obj = iter.next().getAsJsonObject();
            if (obj != null) {
                BaseUrlEntity entity = new BaseUrlEntity();
                entity.setId(obj.get("id").getAsInt());
                entity.setKey(obj.get("key").getAsString());
                entity.setApi(obj.get("api").getAsString());
                entity.setDownload(obj.get("download").getAsString());
                entity.setGroup(obj.get("group").getAsString());
                entity.setStatus(obj.get("status").getAsString());
                entity.setActive(obj.get("isActive").getAsBoolean());
                URL_LIST.add(entity);
            }

        }

    }


    public static List<BaseUrlEntity> urlList() {
        return URL_LIST;
    }

}
