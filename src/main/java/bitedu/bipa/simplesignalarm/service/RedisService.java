package bitedu.bipa.simplesignalarm.service;

import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class RedisService {

    private final StringRedisTemplate redisTemplate;
    private final HashOperations<String, String, Object> hashOperations;

    public RedisService(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
        this.hashOperations = redisTemplate.opsForHash();
    }

    public void setData(String key, String value,Long expiredTime){
        redisTemplate.opsForValue().set(key, value, expiredTime, TimeUnit.MILLISECONDS);
    }

    public String getData(String key){
        return (String) redisTemplate.opsForValue().get(key);
    }

    public Map<String, Object> getAllValuesFromHash(String hashKey) {
        // Hash의 모든 값을 가져오기
        return hashOperations.entries("spring:session:sessions:"+hashKey);
    }

    public Object getValueFromHash(String hashKey, String fieldKey) {
        // Hash에서 특정 필드의 값을 가져오기
        return hashOperations.get("spring:session:sessions:"+hashKey, "sessionAttr:"+fieldKey);
    }


    public void deleteData(String key){
        redisTemplate.delete(key);
    }
}
