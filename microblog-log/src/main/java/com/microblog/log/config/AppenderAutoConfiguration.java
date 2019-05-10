package com.microblog.log.config;


import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.LoggerContext;
import com.microblog.log.anno.EnableKafkaLog;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.encoder.LogstashEncoder;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;


/**
 *功能描述
 * @author lgj
 * @Description  存在bug，会多次调用append 方法，改用xml方式配置
 * @date 4/10/19
*/
@Slf4j
//@Configuration
public class AppenderAutoConfiguration {

    @Autowired
    ApplicationContext context;

    @PostConstruct
    public void init(){


        Map<String, Object> annoClz = context.getBeansWithAnnotation(EnableKafkaLog.class);
        if(annoClz.size() == 0){
            log.warn("Un Enable  the log send to kafka, if you want send ,please use  @EnableKafkaLog ");
            return;
        }

        EnableKafkaLog anno = annoClz.values().iterator().next().getClass().getAnnotation(EnableKafkaLog.class);
        if(anno == null){
            log.warn("Un Enable  the log send to kafka, if you want send ,please use  @EnableKafkaLog ");
            return;
        }
        String brokerAddress =  anno.brokerAddress();
        String applicationName = anno.applicationName();
        log.debug("brokerAddress = {},applicationName={}",brokerAddress,applicationName);



        KafkaAppender kafkaAppender =  new KafkaAppender();
        kafkaAppender.setName("KafkaAppender");
        LoggerContext context =(LoggerContext) LoggerFactory.getILoggerFactory();
        List<Logger> loggers = context.getLoggerList();


        KafkaOutputStreamAppender kafkaOutputStreamAppender  = new KafkaOutputStreamAppender();
        kafkaOutputStreamAppender.setName("kafkaOutputStreamAppender");
        kafkaOutputStreamAppender.setContext(context);
        kafkaOutputStreamAppender.setEncoder(new LogstashEncoder());
        loggers.forEach((v)->{
            if(v.getName().equals("ROOT")){
                System.out.println(v.getName());
               v.addAppender(kafkaAppender);

                v.addAppender(kafkaOutputStreamAppender);
            }
        });
        kafkaOutputStreamAppender.start();

      //  kafkaAppender.start();


    }
}
