package org.libermundi.frostgrave.configuration;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;

@Configuration
@Profile("dev")
public class RedisConfiguration {
    private RedisServer redisServer;

    public RedisConfiguration(RedisProperties redisProperties) {
        this.redisServer= new RedisServer(redisProperties.getPort());
    }

    @PostConstruct
    public void postConstruct() {
        redisServer.start();
    }

}
