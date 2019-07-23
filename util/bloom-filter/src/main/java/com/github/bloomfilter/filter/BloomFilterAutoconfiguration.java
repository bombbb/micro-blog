package com.github.bloomfilter.filter;


import com.github.bloomfilter.redis.RedisClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class BloomFilterAutoconfiguration {

    @Autowired
    public RedisClient redisClient;


    @Bean
    public  BloomFilter redisBloomFilter(){
        RedisBloomFilter filter = new RedisBloomFilter();
        filter.setRedisClient(redisClient);
        return filter;
    }


}
