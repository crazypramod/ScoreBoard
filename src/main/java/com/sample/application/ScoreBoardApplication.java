package com.sample.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ScoreBoardApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(ScoreBoardApplication.class);
        application.run(args);
    }

}
