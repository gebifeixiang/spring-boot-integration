package org.spring.web.component;

import java.util.Collections;
import redis.clients.jedis.Jedis;

/**
 *
 * 项目名称：spring-web 类名称：RedisDistributeLocak 类描述： 创建人：john 创建时间：2018年8月2日
 * 上午11:50:10 修改人：john 修改时间：2018年8月2日 上午11:50:10 修改备注：
 * 
 * @version
 *
 */
public class RedisDistributeLock {
	private static final String LOCK_SUCCESS = "OK";
	private static final String SET_IF_NOT_EXIST = "NX";
	private static final String SET_WITH_EXPIRE_TIME = "PX";
	private static final Long RELEASE_SUCCESS = 1L;

	/**
	 * 尝试获取分布式锁
	 * 
	 * @param jedis
	 *            Redis客户端
	 * @param lockKey
	 *            锁
	 * @param requestId
	 *            请求标识
	 * @param expireTime
	 *            超期时间
	 * @return 是否获取成功
	 */
	public static boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        
		System.out.println("jedis>>>>>>>>"+jedis);
		String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);
		
		System.out.println("redisLockResult>>>>>>>"+result);

		if (LOCK_SUCCESS.equals(result)) {
			return true;
		}
		return false;

	}

	/**
	 * 释放分布式锁
	 * 
	 * @param jedis
	 *            Redis客户端
	 * @param lockKey
	 *            锁
	 * @param requestId
	 *            请求标识
	 * @return 是否释放成功
	 */
	public static boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId) {

		String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
		Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

		if (RELEASE_SUCCESS.equals(result)) {
			return true;
		}
		return false;
	}
}
