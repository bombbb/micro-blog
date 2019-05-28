package com.microblog.user.service.auth;

import com.microblog.common.zk.ZkCli;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class UserAuthAutoConfiguration {

    @Bean
    public ZkCli zkCli(){
        ZkCli zkCli = new ZkCli();
        zkCli.connect("localhost:2181");
        return zkCli;
    }

}
