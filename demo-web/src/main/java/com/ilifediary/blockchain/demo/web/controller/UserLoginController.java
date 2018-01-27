package com.ilifediary.blockchain.demo.web.controller;

import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by chenyu.jcy on 2018/01/27.
 *
 * @author 焦晨宇
 * @date 2018/01/27
 */
@Controller
@RequestMapping("/user")
@Slf4j
public class UserLoginController extends BaseController {
    /**
     * hello world
     * @param request HttRequest
     * @param response HttpResponse
     */
    @RequestMapping(value = "/hello", method = { RequestMethod.GET,
        RequestMethod.POST })
    public void helloWorld(HttpServletRequest request,
                        HttpServletResponse response) {
        try {
            sendSuccessMessage(request, response, Collections.singletonMap("key", "value"));
        } catch (Exception e) {
            sendFailureMessage(request, response);
        }
    }

    /**
     * get user info
     * @param request HttRequest
     * @param response HttpResponse
     */
    @RequestMapping(value = "/get", method = { RequestMethod.GET,
        RequestMethod.POST })
    public void get(HttpServletRequest request,
                           HttpServletResponse response) {
        try {
            String access_token = WeiboConfig.getValue("access_token");
            String uid = args[0];
            Users um = new Users(access_token);
            try {
                User user = um.showUserById(uid);
                Log.logInfo(user.toString());
            } catch (WeiboException e) {
                e.printStackTrace();
            }
            sendSuccessMessage(request, response, Collections.singletonMap("key", "value"));
        } catch (Exception e) {
            sendFailureMessage(request, response);
        }
    }
}
