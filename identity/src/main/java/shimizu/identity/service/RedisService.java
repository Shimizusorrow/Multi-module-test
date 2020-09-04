package shimizu.identity.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.Objects;

/**
 * @author Shimizu
 * @version 1.0
 * @date 2020/9/4 11:47
 */
@Service
@AllArgsConstructor
@Slf4j
public class RedisService {
    private final RedisTemplate redisTemplate;

    public void connection() {
        redisTemplate.opsForValue().set("1", "1");
        log.info((String) redisTemplate.opsForValue().get("name"));
    }

    /**
     * 插入值
     *
     * @param k
     * @param v
     * @return
     */
    public boolean setVal(String k, Object v) {
        try {
            ValueOperations ops = redisTemplate.opsForValue();
            ops.set(k, v);
        } catch (Exception e) {
            log.error(String.format("插入key: %s 失败", k));
            return false;
        }
        return true;
    }

    /**
     * 获得k的值
     *
     * @param k
     * @return
     */
    public String getVal(String k) {
        try {
            ValueOperations ops = redisTemplate.opsForValue();
            if (!Objects.isNull(ops.get(k))) {
                return (String) ops.get(k);
            }
        } catch (Exception e) {
            log.error(String.format("找不到key: %s 所对应的值", k));
        }
        return null;
    }

}
