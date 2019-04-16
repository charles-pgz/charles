package com.pgz.charles;

import com.pgz.charles.util.PgzProperties;
import com.pgz.charles.web.HelloWorldController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class P2pApplicationTests {

    @Autowired
    private PgzProperties pgzProperties;

    private MockMvc mvc;

    @Before
    public void setup() throws Exception{
        mvc= MockMvcBuilders.standaloneSetup(new HelloWorldController()).build();
    }
    @Test
    public void testHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/home").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Home")));
    }

    @Test
    public void testProperties(){
        Assert.assertEquals(pgzProperties.getName(),"charles");
        Assert.assertEquals(pgzProperties.getEmail(),"charles.pgz@qq.com");
    }
    /*@Test
    public void contextLoads() {
    }*/

}
