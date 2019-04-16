package com.pgz.charles.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Administrator
 * @title: PgzProperties
 * @projectName charles
 * @description: TODO
 * @date 19/4/1616:17
 */
@Component
public class PgzProperties {
    @Value("${com.pgz.name}")
    private String name;
    @Value("${com.pgz.email}")
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
