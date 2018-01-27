package com.ilifediary.blockchain.demo.web.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ilifediary.blockchain.demo.web.constant.Constants;
import com.ilifediary.blockchain.demo.web.utils.HtmlUtils;

/**
 * Created by chenyu.jcy on 2018/01/27.
 *
 * @author 焦晨宇
 * @date 2018/01/27
 */
public class BaseController {

    /**
     * 提示成功信息
     *
     */
    void sendSuccessMessage(HttpServletRequest request, HttpServletResponse response, Object data) {
        Map<String, Object> result = new HashMap<>(16);
        result.put(Constants.CODE, Constants.SUCCESS);
        result.put(Constants.MSG, Constants.SUCCESS_MSG);
        result.put(Constants.DATA, data);
        HtmlUtils.writeJson(request, response, result);
    }

    /**
     * 提示成功信息
     *
     */
    void sendSuccessMessage(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<>(16);
        result.put(Constants.CODE, Constants.SUCCESS);
        result.put(Constants.MSG, Constants.SUCCESS_MSG);
        HtmlUtils.writeJson(request, response, result);
    }

    /**
     * 发送消息和信息，所有消息 和/或 信息发送都可以适用
     */
    void sendMessage(HttpServletRequest request, HttpServletResponse response, Object result) {
        HtmlUtils.writeJson(request, response, result);
    }

    /**
     * 验证用户请求是否合法
     */
    void sendIllegal(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.CODE, Constants.AUTH_ERROR);
        result.put(Constants.MSG, Constants.AUTH_ERROR_MSG);
        HtmlUtils.writeJson(request, response, result);
    }

    /**
     * 用户操作无效
     */
    void sendRequestInvalid(HttpServletRequest request, HttpServletResponse response, String message)
    {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.CODE, Constants.REQUEST_ERROR);
        result.put(Constants.MSG, message);
        HtmlUtils.writeJson(request, response, result);
    }

    /**
     * 发送失败的消息，附带默认信息
     */
    void sendFailureMessage(HttpServletRequest request, HttpServletResponse response) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.CODE, Constants.SYSTEM_ERROR);
        result.put(Constants.MSG, Constants.SYSTEM_ERROR_MSG);
        HtmlUtils.writeJson(request, response, result);
    }

    /**
     * 发送失败的消息(不附带信息,信息的内容自己写)
     */
    void sendFailureMessage(HttpServletRequest request, HttpServletResponse response, String message) {
        Map<String, Object> result = new HashMap<String, Object>();
        result.put(Constants.CODE, Constants.SYSTEM_ERROR);
        result.put(Constants.MSG, message);
        HtmlUtils.writeJson(request, response, result);
    }
}
