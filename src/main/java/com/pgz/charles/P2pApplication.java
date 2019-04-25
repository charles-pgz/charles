package com.pgz.charles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication() //exclude = DataSourceAutoConfiguration.class , scanBasePackages= "com.*"
//@ComponentScan("com.*")
//@EnableJpaRepositories("com.pgz.charles.repository")
//@EntityScan("com.pgz.charles.*")
public class P2pApplication {

    public static void main(String[] args) {
        SpringApplication.run(P2pApplication.class, args);
    }

}
