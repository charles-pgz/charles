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

    public static String longestPalindrome(String string) {
        //-----------------------------------
        //转换字符串
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("#");
        for (int i = 0; i < string.length(); i++) {
            stringBuilder.append(string.charAt(i));
            stringBuilder.append("#");
        }
        //-----------------------------------
        int rightIndex = 0;
        int centerIndex = 0;
        //求len中的最大
        int answer = 0;
        //answer最大时的中心
        int index = 0;
        int len[] = new int[stringBuilder.length() ];
        for (int i = 1; i < stringBuilder.length(); i++) {
            //当rightIndex > i，那么我们就在rightIndex - i 与len[2 * centerIndex - i](len[j])，取得最小值
            //因为当i + len[j] < rightIndex时，我们就把len[i]更新为len[j]
            //但是如果i + len[j] >= rightIndex时，我们暂且将len[i]定更新为rightIndex - i,超出的部分需要我们一个一个的匹配
            if (rightIndex > i) {
                len[i] = Math.min(rightIndex - i, len[2 * centerIndex - i]);
            } else {
                len[i] = 1;
            }
            //一个一个匹配
            //要么是超出的部分，要么是i > rightIndex
            while(i - len[i] >= 0 && i + len[i] < stringBuilder.length() && stringBuilder.charAt(i - len[i]) == stringBuilder.charAt(i + len[i])) {
                len[i]++;
            }
            //当 len[i] + i > rightIndex,我们需要更新centerIndex和rightIndex
            //至于为什么会这样做，理解一下rightIndex和centerIndex的含义
            if(len[i] + i > rightIndex) {
                rightIndex = len[i] + i;
                centerIndex = i;
            }
            if(len[i] > answer) {
                answer = len[i];
                index = i;
            }
        }
        //截取字符串
        //为什么index - answer + 1,因为len[i] - 1才是原来的回文字符串长度，而answer记录的是len中最大值
        return stringBuilder.substring(index - answer + 1, index + answer).replace("#", "");
    }
    public static void main(String[] args) {
        System.out.println(longestPalindrome("aaaaaaaaacccccbbbbccccccccccbbbbcccccaaassscvvv"));
    }
}
