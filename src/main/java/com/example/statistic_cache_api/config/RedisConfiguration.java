package com.example.statistic_cache_api.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;
import java.util.Objects;

@Slf4j
@Configuration
public class RedisConfiguration {

    private static final Integer CACHING_TIME_IN_MINUTES = 2;

    @Bean
    public RedisCacheManager redisCacheManager(RedisConnectionFactory connectionFactory) {
        log.info("Initializing RedisCacheManager with cache time of {} minutes", CACHING_TIME_IN_MINUTES);
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofMinutes(CACHING_TIME_IN_MINUTES))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer()));

        RedisCacheManager cacheManager = RedisCacheManager.builder(Objects.requireNonNull(connectionFactory))
                .cacheDefaults(config)
                .build();

        log.info("RedisCacheManager successfully created: {}", cacheManager);

        return cacheManager;
    }
}