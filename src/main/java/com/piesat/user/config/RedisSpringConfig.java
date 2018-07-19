package com.piesat.user.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;

/**
 * Redis配置类
 */
@Configuration
@PropertySource(value="classpath:redis.properties")
public class RedisSpringConfig {
    @Value("${redis.maxTotal}")
    private Integer redisMaxTotal;

    @Value("${redis.nodel.host}")
    private String redisNodelHost;

    @Value("${redis.nodel.port}")
    private Integer redisNodelPort;

    private JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxTotal(redisMaxTotal);
        return jedisPoolConfig;
    }

    @Bean
    public ShardedJedisPool shardedJedisPool(){
        List<JedisShardInfo> jedisShardInfos=new ArrayList<JedisShardInfo>();
        jedisShardInfos.add(new JedisShardInfo(redisNodelHost,redisNodelPort));
        return new ShardedJedisPool(jedisPoolConfig(),jedisShardInfos);
    }
}
