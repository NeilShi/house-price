package houseprice.cache;

import houseprice.utils.SerializeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@Component("redisCache")
public class RedisCache {

    @Autowired
    JedisPool jedisPool;

    /**
     * 从Redis缓存获取数据
     * @param redisKey
     * @return
     */
    public Object getDataFromRedis(String redisKey) {
        Jedis jedis = jedisPool.getResource();
        byte[] byteArray = jedis.get(redisKey.getBytes());

        if (byteArray != null) {
            return SerializeUtil.unSerialize(byteArray);
        }
        return null;
    }

    /**
     * 保存数据到Redis
     * @param redisKey
     */
    public String saveDataToRedis(String redisKey, Object obj) {

        byte[] bytes = SerializeUtil.serialize(obj);

        Jedis jedis = jedisPool.getResource();

        String code = jedis.set(redisKey.getBytes(), bytes);

        return code;
    }
}
