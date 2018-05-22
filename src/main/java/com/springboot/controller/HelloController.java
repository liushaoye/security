package com.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by
 *
 * @author: liuya
 * @Date: 2018/5/22 17:47
 * @Description: security
 */

@Controller
public class HelloController {


    @RequestMapping("/")
    public String index() {
        return "index";
    }

    @RequestMapping("/index")
    public String index2() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }


}
