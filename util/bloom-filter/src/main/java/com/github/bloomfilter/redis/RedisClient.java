package com.github.bloomfilter.redis;

public interface RedisClient {

    boolean add(final String key,final String value);

    boolean[] addMulti(final String key, final String... values);

    boolean exists(final String key, final String value);

    boolean[] existsMulti(final String key, final String... values);

}
