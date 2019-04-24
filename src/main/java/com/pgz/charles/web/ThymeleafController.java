package com.pgz.charles.web;

import com.pgz.charles.domain.User;
import com.pgz.charles.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * @author charles
 * @title: ThymeleafController
 * @projectName charles
 * @description: TODO
 * @date 19/4/2415:41
 */
@Controller
public class ThymeleafController {

    //@Autowired
    //private UserRepository userRepository;

    @RequestMapping("/string")
    public String string(ModelMap map){
        map.addAttribute("userName","charles");
        return "string";
    }
    @RequestMapping("/if")
    public String ifunless(ModelMap map){
        map.addAttribute("flag","yes");
        return "if";
    }
    @RequestMapping("/list")
    public String list(ModelMap map){
        map.addAttribute("users",getUserList());//userRepository.findAll()
        return "list";
    }
    @RequestMapping("/url")
    public String url(ModelMap map){
        map.addAttribute("type", "link");
        map.addAttribute("pageId", "springcloud/2017/09/11/");
        map.addAttribute("img", "http://www.ityouknow.com/assets/images/neo.jpg");
        return "url";
    }
    @RequestMapping("/eq")
    public String eq(ModelMap map){
        map.addAttribute("name", "neo");
        map.addAttribute("age", 30);
        map.addAttribute("flag", "yes");
        return "eq";
    }
    @RequestMapping("/switch")
    public String switchcase(ModelMap map){
        map.addAttribute("sex", "woman");
        return "switch";
    }

    private List<User> getUserList(){
        List<User> list=new ArrayList<User>();
        User user1=new User("大牛","123456");
        User user2=new User("小牛","123563");
        User user3=new User("纯洁的微笑","666666");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        return  list;
    }
}
