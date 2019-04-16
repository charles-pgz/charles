package com.pgz.charles.web;

import org.springframework.web.bind.annotation.*;

@RestController  //Controller 里面的方法都以 json 格式输出
@RequestMapping("/home")   //将 HTTP 请求映射到 MVC 和 REST 控制器的处理方法上
public class HelloWorldController {
    @GetMapping()
    public String index(){
        return "Home";
    }
    @GetMapping("/hello")
    public String hello(){
        return "Hello World";
    }
    @GetMapping(value = "/name")
    public String getName(@RequestParam(value = "person", required = false) String personName){
        return personName;
    }
    /**
     * @Author Administrator
     * @Description //TODO
     * @Date 19/4/16 9:45
     * @Param [id]
     * @return java.lang.String
     **/
    @GetMapping(value="/fetch/{id}")
    public String getDynamicUriValue(@PathVariable String id){
        System.out.println("ID is " + id);
        return "Dynamic URI parameter fetched";
    }

}
