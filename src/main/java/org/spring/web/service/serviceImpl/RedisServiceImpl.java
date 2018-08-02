package org.spring.web.service.serviceImpl;

import org.spring.web.component.RedisDistributeLock;
import org.spring.web.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

/**
*
* 项目名称：spring-web
* 类名称：RedisServiceImpl
* 类描述：
* 创建人：john
* 创建时间：2018年8月2日 下午12:34:29
* 修改人：john
* 修改时间：2018年8月2日 下午12:34:29
* 修改备注：
* @version
*
*/
@Service
public class RedisServiceImpl{
	@Autowired
	private Jedis jedis;
	public boolean tryGetDistributedLock(String lockKey,String requestId,int expireTime ){
		return RedisDistributeLock.tryGetDistributedLock(jedis, lockKey, requestId, expireTime);
	}
	
	public boolean releaseDistributedLock(String lockKey,String requestId){
		return RedisDistributeLock.releaseDistributedLock(jedis, lockKey, requestId);
		
	}

}
