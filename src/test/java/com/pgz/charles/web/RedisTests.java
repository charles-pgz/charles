package com.pgz.charles.web;

import com.pgz.charles.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author charles
 * @title: RedisTests
 * @projectName charles
 * @description: TODO
 * @date 19/4/1916:39
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTests {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void test(){
        stringRedisTemplate.opsForValue().set("1","111");
        Assert.assertEquals("111",stringRedisTemplate.opsForValue().get("1"));
    }

    @Test
    public void testObj() throws InterruptedException {
        User user=new User("a","123456","a@qq.com","aa","15600000000",new Date().toLocaleString());
        ValueOperations<String,User> vo=redisTemplate.opsForValue();
        vo.set("u1",user);
        vo.set("u2",user,1, TimeUnit.MINUTES);
        Thread.sleep(1000);
        boolean exists = redisTemplate.hasKey("u2");
        if(exists){
            System.out.println("exist is true");
        }else{
            System.out.println("exist is false");
        }
        Assert.assertEquals("a",vo.get("a").getUserName());
        //Assert.assertEquals("a",((User)redisTemplate.opsForValue().get("u1")).getUserName());
    }

}
