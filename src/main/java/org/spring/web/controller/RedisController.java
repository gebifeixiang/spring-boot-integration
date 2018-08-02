package org.spring.web.controller;

import org.spring.web.service.serviceImpl.RedisServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* 项目名称：spring-web
* 类名称：RedisController
* 类描述：
* 创建人：john
* 创建时间：2018年8月2日 下午2:16:22
* 修改人：john
* 修改时间：2018年8月2日 下午2:16:22
* 修改备注：
* @version
*
*/
@RestController
@RequestMapping("/redis")
public class RedisController {
  
	@Autowired
	private RedisServiceImpl redisService;
	@RequestMapping("/getLock")
	public boolean getRedisLock(){
		System.out.println(">>>>>>>>>>>>>>>>>>");
		return redisService.tryGetDistributedLock("redisLock", "11200", 2000000000);
	}
	
	@GetMapping("/releaseLock")
	public boolean releaseRedisLock(){
		return redisService.releaseDistributedLock("redisLock", "11200");
	}
}
