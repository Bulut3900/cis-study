package com.cisstudy.cisstudybackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.cisstudy.cisstudybackend.mapper")
public class CisStudyBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CisStudyBackendApplication.class, args);
    }
}