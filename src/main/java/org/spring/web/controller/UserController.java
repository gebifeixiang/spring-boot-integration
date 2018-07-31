package org.spring.web.controller;

import org.spring.web.entity.User;
import org.spring.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
*
* 项目名称：spring-web
* 类名称：UserController
* 类描述：
* 创建人：john
* 创建时间：2018年7月28日 下午12:15:36
* 修改人：john
* 修改时间：2018年7月28日 下午12:15:36
* 修改备注：
* @version
*
*/
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
	UserService userService;
    @RequestMapping("/selectByUserId")
    public User selectByUserId(Integer id){
    	id=1;
    	return userService.selectUserById(id);
    }
    
    @RequestMapping("/updateUser")
    public int updateUser(User user){
    	user.setPassword("222");
    	user.setUserName("你好");
    	user.setAge(110);
    	user.setId(1);
    	
    	return userService.updateUser(user);
    }
    
    @RequestMapping("/getRedisUser")
    public String getRedisUser(){
    	return userService.getUser();
    }
}
