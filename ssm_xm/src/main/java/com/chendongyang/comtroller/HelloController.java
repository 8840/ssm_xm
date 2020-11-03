package com.chendongyang.comtroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {
    @ResponseBody
    @RequestMapping("/hello1")
    public String hello1(){
        System.out.println("hello springmvc 你妈的");
        return "hello springmvc 你妈的";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        System.out.println("hello springmvc 你妈的");
        return "hello";
    }

    @ResponseBody
    @RequestMapping("/hello3")
    public Map hello3(){
        System.out.println("hello springmvc 你妈的");
        Map map=new HashMap();
        map.put("total",12);
        map.put("rows","dfadfa");
        return map;
    }
    //转发到页面
    @RequestMapping("/forward1")
    public String forward(){
        System.out.println("进来forward");
        return "aaa";
    }
    //转发到根路径下的页面
    @RequestMapping("/forward2")
    public String forward2(){
        System.out.println("hello springmvc 你妈的");
        return "forward:/bbb.jsp";
    }
    //转发到requestMapping下
    @RequestMapping("/forward3")
    public String forward3(){
        System.out.println("hello springmvc 你妈的");
        return "forward:/forward1";
    }
    //重定向到根路径下的页面
    @RequestMapping("/redirect1")
    public String redirect1(){
        System.out.println("hello springmvc 你妈的");
        return "redirect:/bbb.jsp";
    }
    //重定向到requestMapping下
    @RequestMapping("/redirect2")
    public String redirect2(){
        System.out.println("hello springmvc 你妈的");
        return "redirect:/forward1";
    }


}
