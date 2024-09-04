package hello.triggerredis.common.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@Configuration
@EnableCaching
@RequiredArgsConstructor
public class CacheConfig extends CachingConfigurerSupport {
    private final RedisConnectionFactory redisConnectionFactory;
    @Value("${cache.default-ttl}")
    private Integer ttl;

    @Bean
    public CacheManager cacheManager() {
        CacheManager cacheManager;
        try {
            RedisCacheManager redisCacheManager = RedisCacheManager
                    .builder(redisConnectionFactory)
                    .cacheDefaults(defaultConf())
//				.withInitialCacheConfigurations(confMap())
                    .build();
            redisConnectionFactory.getConnection().ping();
            cacheManager = redisCacheManager;
        } catch (Exception e) {
            cacheManager = new ConcurrentMapCacheManager();
        }
        return cacheManager;
    }

    private RedisCacheConfiguration defaultConf() {
        return RedisCacheConfiguration.defaultCacheConfig()
                .entryTtl(Duration.ofSeconds(ttl))
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(new StringRedisSerializer())) // 키 직렬화 방식을 String으로 설정
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new GenericJackson2JsonRedisSerializer())); // 값 직렬화 방식을 JSON으로 설정
    }

}