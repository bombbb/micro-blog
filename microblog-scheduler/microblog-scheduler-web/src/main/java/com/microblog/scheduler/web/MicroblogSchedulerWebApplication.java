package com.microblog.scheduler.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;


@EnableDiscoveryClient
@MapperScan(basePackages = "common.microblog.scheduler.dao.mapper")
@SpringBootApplication
@ComponentScan(basePackages = "com.microblog.*")
public class MicroblogSchedulerWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroblogSchedulerWebApplication.class, args);
    }

}