package com.pgz.charles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class) //scanBasePackages= "com"
//@ComponentScan("com.pgz.charles.*")
//@EnableJpaRepositories("com.pgz.charles.repository")
//@EntityScan("com.pgz.charles.domain")
public class P2pApplication {

    public static void main(String[] args) {
        SpringApplication.run(P2pApplication.class, args);
    }

}
