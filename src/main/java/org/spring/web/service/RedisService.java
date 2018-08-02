package org.spring.web.service;

import redis.clients.jedis.Jedis;

/**
*
* 项目名称：spring-web
* 类名称：RedisService
* 类描述：
* 创建人：john
* 创建时间：2018年8月2日 下午2:17:40
* 修改人：john
* 修改时间：2018年8月2日 下午2:17:40
* 修改备注：
* @version
*
*/
public interface RedisService {
	public  boolean tryGetDistributedLock(Jedis jedis, String lockKey, String requestId, int expireTime);
	public  boolean releaseDistributedLock(Jedis jedis, String lockKey, String requestId);
}
