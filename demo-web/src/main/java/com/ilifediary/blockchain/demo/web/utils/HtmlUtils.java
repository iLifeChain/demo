package com.ilifediary.blockchain.demo.web.utils;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * Created by chenyu.jcy on 2018/01/27.
 *
 * @author 焦晨宇
 * @date 2018/01/27
 */
public class HtmlUtils {

    public static void writeJson(HttpServletRequest request, HttpServletResponse response, String jsonStr) {
        write(request, response,jsonStr);
    }

    public static void writeJson(HttpServletRequest request, HttpServletResponse response, Object object){
        response.setContentType("application/json");
        write(request, response, JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect));
    }

    public static void writeArrayJson(HttpServletRequest request, HttpServletResponse response, Object object){
        response.setContentType("application/json");
        write(request, response, JSON.toJSONString(object, SerializerFeature.DisableCircularReferenceDetect));
    }

    public static void writeHtml(HttpServletRequest request, HttpServletResponse response, String htmlStr) {
        write(request, response,htmlStr);
    }

    private static void write(HttpServletRequest request, HttpServletResponse response, String str){
        try {
            //设置页面不缓存
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setCharacterEncoding("UTF-8");
            PrintWriter out = response.getWriter();
            out.print(str);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
