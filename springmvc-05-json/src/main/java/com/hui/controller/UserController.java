package com.hui.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hui.pojo.User;
import com.hui.utils.JsonUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//下面的所有方法只会返回字符串，不会解析视图
@RestController
public class UserController {

    @RequestMapping("/j1")
    // @ResponseBody 不走视图解析器，会直接返回一个字符串，有了RestController就不需要ResponseBody了
    public String json1() throws JsonProcessingException {

        //jackson，ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("狗币",1,"狗");
        String str = mapper.writeValueAsString(user);
        return str;
    }


    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        List<User> userList = new ArrayList<User>();

        User user1 = new User("狗币1",1,"狗");
        User user2 = new User("狗币2",1,"狗");
        User user3 = new User("狗币3",1,"狗");
        User user4 = new User("狗币4",1,"狗");

        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        //优化写法
        return new ObjectMapper().writeValueAsString(userList);
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();

        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //自定义方式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(sdf);

        Date date = new Date();

        return mapper.writeValueAsString(date);
    }

    @RequestMapping("/j4")
    public String json4() {
        Date date = new Date();
        return JsonUtils.getJson(date,"");
    }
}
