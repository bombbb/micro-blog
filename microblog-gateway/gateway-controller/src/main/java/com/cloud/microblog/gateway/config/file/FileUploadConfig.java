package com.cloud.microblog.gateway.config.file;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

@Configuration
public class FileUploadConfig {

    @Bean
    public CommonsMultipartResolver commonsMultipartResolver(){
        CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        //<!-- 文件大小最大值 -->
        resolver.setMaxUploadSize(10*1024*1024);
        //
        resolver.setMaxInMemorySize(10*1024*1024);

        return resolver;
    }
}
