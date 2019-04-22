package com.pgz.charles.web;

import com.pgz.charles.domain.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.UUID;

/**
 * @author charles
 * @title: UserController
 * @projectName charles
 * @description: TODO
 * @date 19/4/229:52
 */
@RestController
public class UserController {
    @RequestMapping("/getUser")
    @Cacheable(value = "user-key",key = "caches[0].name")
    public User getUser(){
        User user=new User("name","123456","name@qq.com","nickname","15600000000", new Date().toLocaleString());
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }

    @RequestMapping("/uuid")
    public String uid(HttpSession httpSession){
        UUID uuid = (UUID) httpSession.getAttribute("uuid");
        if(uuid == null){
            uuid = UUID.randomUUID();
        }
        httpSession.setAttribute("uuid",uuid);
        return httpSession.getId();
    }
}
