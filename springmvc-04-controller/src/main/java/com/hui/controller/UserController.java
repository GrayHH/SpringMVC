package com.hui.controller;

import com.hui.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @GetMapping("/t3")
    //养成良好的习惯，@RequestParam("name") String name 接收参数
    public String test1(@RequestParam("name") String name, Model model){
        //1.接收前端参数
        System.out.println("接收到前端参数为"+name);

        //2.将返回结果传递给前端
        model.addAttribute("msg",name);

        //3.视图跳转
        return "test";
    }

    /*
    * 1.接收前端用户传递的参数，判断参数名字，
    *
    * */

    @GetMapping("/t4")
    public String test2(User user){
        System.out.println("接收到前端参数为"+user);
        return "test";
    }

}
