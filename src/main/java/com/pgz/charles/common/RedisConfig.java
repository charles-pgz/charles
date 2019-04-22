package com.pgz.charles.common;

import com.pgz.charles.domain.User;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.lang.reflect.Method;

/**
 * @author charles
 * @title: RedisConfig
 * @projectName charles
 * @description: redis配置
 * @date 19/4/1916:29
 */
@Configuration
@EnableCaching
public class RedisConfig extends CachingConfigurerSupport {

    public KeyGenerator keyGenerator(){
        return new KeyGenerator() {
            @Override
            public Object generate(Object target, Method method, Object... params) {
                StringBuilder sb=new StringBuilder();
                sb.append(target.getClass().getName());
                sb.append(method.getName());
                for (Object param :params){
                    sb.append(param.toString());
                }
                return sb.toString();
            }
        };
    }
}
