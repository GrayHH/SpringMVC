package com.hui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class LoginController {

    @RequestMapping("/login")
    public String login(String username, String password, HttpSession session, Model model){
        //用户的信息存在session中
        session.setAttribute("userLoginInfo",username);
        model.addAttribute("username",username);
        return "main";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }

    @RequestMapping("/gologin")
    public String gologin(){
        return "login";
    }

    @RequestMapping("/out")
    public String out(HttpSession session){
        //用户的信息存在session中
        session.removeAttribute("userLoginInfo");
        return "main";
    }
}
