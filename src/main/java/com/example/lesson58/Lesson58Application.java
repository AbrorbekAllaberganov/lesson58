package com.example.lesson58;

import com.example.lesson58.model.Result;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableJpaAuditing
public class Lesson58Application {

    @Bean
    public Result result(){
        return new Result();
    }

    public static void main(String[] args) {
        SpringApplication.run(Lesson58Application.class, args);
    }

}
