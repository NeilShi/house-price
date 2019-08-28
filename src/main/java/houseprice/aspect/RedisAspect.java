package houseprice.aspect;

import houseprice.cache.RedisCache;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


/**
 * AOP实现Redis缓存处理
 */
@Component
@Aspect
public class RedisAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(RedisAspect.class);

    @Autowired
    @Qualifier("redisCache")
    private RedisCache redisCache;

    @Around("@annotation(houseprice.annotation.RedisCache)")
    public Object around(ProceedingJoinPoint joinPoint) {
        long startTime = System.currentTimeMillis();

        String appId = null;
        Object[] args = joinPoint.getArgs();
        if (args != null && args.length > 0) {
            appId = String.valueOf(args[0]);
        }

        // 获取目标方法所在类
        String target = joinPoint.getTarget().toString();
        String className = target.split("@")[0];

        // 获取目标方法的方法名称
        String methodName = joinPoint.getSignature().getName();

        //redis中key格式：    appId:方法名称
        String redisKey = appId + ":" + className + "." + methodName;

        Object obj = redisCache.getDataFromRedis(redisKey);
        if (obj != null) {
            LOGGER.info("**********从Redis中查到了数据**********");
            LOGGER.info("Redis的KEY值:" + redisKey);
            LOGGER.info("Redis的VALUE值:" + obj.toString());
            return obj;
        }
        long endTime = System.currentTimeMillis();
        LOGGER.info("Redis缓存AOP处理所用时间:" + (endTime-startTime));
        LOGGER.info("**********没有从Redis查到数据**********");

        try {
            joinPoint.proceed();
        } catch (Throwable e) {
            e.printStackTrace();
        }

        LOGGER.info("**********开始从MySQL查询数据**********");
        //后置：将数据库查到的数据保存到Redis
        String code = redisCache.saveDataToRedis(redisKey, obj);
        if("OK".equals(code)) {
            LOGGER.info("**********数据成功保存到Redis缓存!!!**********");
            LOGGER.info("Redis的KEY值:" + redisKey);
            LOGGER.info("Redis的VALUE值:" + obj.toString());
        }
        return obj;
    }
}
