package com.pgz.charles.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * @author charles
 * @title: SessionConfig
 * @projectName charles
 * @description: 缓存配置
 * @date 19/4/2214:57
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 60*60*24)
public class SessionConfig {
}
