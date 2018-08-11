package org.spring.web.service.serviceImpl;

import java.util.concurrent.TimeUnit;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.web.entity.User;
import org.spring.web.mapper.UserMapper;
import org.spring.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
*
* 项目名称：spring-web
* 类名称：UserServiceImpl
* 类描述：
* 创建人：john
* 创建时间：2018年7月28日 上午11:53:16
* 修改人：john
* 修改时间：2018年7月28日 上午11:53:16
* 修改备注：
* @version
*
*/
@Service
public class UserServiceImpl  implements  UserService{
  private static Logger logger =LoggerFactory.getLogger(UserServiceImpl.class);


	@Autowired
	private UserMapper userMapper;
	@Autowired
	private RedisTemplate redisTemplate;
	
	
	@Transactional
	public int inserUser(User user) {
	/*	user.setUserName("nihao");
		user.setAge(11);
		user.setPassword("password");
		user.setId(11);*/
		
		 return userMapper.insertUser(user);
		//throw new RuntimeException("抛异常");
	}

	public User selectUserById(Integer id) {
		User user=userMapper.selectUserById(id);
		System.out.println("根据用户ID>>"+id+"查询的用户信息>>>>>."+user);
		return user;
	}

	
	@Override
	public int updateUser(User user) {
		return userMapper.updateUser(user);
	}

	
	@Override
	public String getUser() {
		 User user=new User();
		 user.setId(22);
		 user.setUserName("interview");
		 ValueOperations<String, User> operations=redisTemplate.opsForValue();
		 operations.set("com.yfli", user);
	     operations.set("com.neo.f", user,1,TimeUnit.SECONDS);
	     try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}        
	        //redisTemplate.delete("com.neo.f");
	        boolean exists=redisTemplate.hasKey("com.neo.f");
	        if(exists){
	            System.out.println("exists is true");
	        }else{
	            System.out.println("exists is false");
	        }     
	        User redisUser=operations.get("com.yfli");
		   return redisUser.toString();
	}

}
