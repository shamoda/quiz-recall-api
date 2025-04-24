package com.app.quizrecall.config;

import io.lettuce.core.ClientOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.cache.RedisCacheManagerBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceClientConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

import java.time.Duration;

@Configuration
public class RedisConfig {
    @Value("${redis.url}")
    String url;

    @Value("${redis.port}")
    int port;

    @Value("${redis.password}")
    String password;

    @Bean
    public RedisStandaloneConfiguration redisStandaloneConfiguration() {
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(url, port);
        redisStandaloneConfiguration.setPassword(password);
        return redisStandaloneConfiguration;
    }
//    @Bean
//    public ClientOptions clientOptions() {
//        return ClientOptions.builder()
//                .disconnectedBehavior(ClientOptions.DisconnectedBehavior.REJECT_COMMANDS)
//                .autoReconnect(true)
//                .build();
//    }

//    @Bean
//    public RedisConnectionFactory connectionFactory(RedisStandaloneConfiguration redisStandaloneConfiguration) {
//
//        LettuceClientConfiguration configuration = LettuceClientConfiguration.builder()
//                .clientOptions(clientOptions())
//                .useSsl()
//                .build();
//
//        return new LettuceConnectionFactory(redisStandaloneConfiguration, configuration);
//    }

    @Bean
    public RedisCacheManagerBuilderCustomizer redisCacheManagerBuilderCustomizer() {
        return (builder) -> builder
                .withCacheConfiguration("presignedurl",
                        RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(100)));

    }
}
