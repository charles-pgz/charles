package com.pgz.charles.web;

import com.pgz.charles.util.PgzProperties;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author charles
 * @title: PgzPropertiesTests
 * @projectName charles
 * @description: TODO
 * @date 19/4/1815:52
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PgzPropertiesTests {

    @Autowired
    private PgzProperties pgzProperties;

    @Test
    public void testProperties(){
        Assert.assertEquals(pgzProperties.getName(),"charles");
        Assert.assertEquals(pgzProperties.getEmail(),"charles.pgz@qq.com");
    }
}
