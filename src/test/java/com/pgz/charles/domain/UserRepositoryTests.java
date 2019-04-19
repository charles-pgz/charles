package com.pgz.charles.domain;

import com.pgz.charles.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.DateFormat;
import java.util.Date;

/**
 * @author charles
 * @title: UserRepositoryTests
 * @projectName charles
 * @description: TODO
 * @date 19/4/1815:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserRepositoryTests {

    @Autowired
    private UserRepository userRepository;

    @Test
    public void testUersRepository(){
        Date date =new Date();
        DateFormat dateFormat=DateFormat.getDateTimeInstance(DateFormat.LONG,DateFormat.LONG);
        String formatedDate=dateFormat.format(date);

        userRepository.save(new User("a",".","","aa","15600000000",formatedDate));
        userRepository.save(new User("b",".","","bb","15600000001",formatedDate));
        userRepository.save(new User("c",".","","cc","15600000002",formatedDate));

        Assert.assertEquals(3,userRepository.findAll().size());
        Assert.assertEquals("a",userRepository.findByUserNameOrNickNameOrEmail("a","",""));
        userRepository.delete(userRepository.findByUserName("b"));

    }
}
