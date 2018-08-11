package org.spring.web.controller;

import org.spring.web.entity.User;
import org.spring.web.entity.UserRole;
import org.spring.web.service.UserRoleService;
import org.spring.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
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
    @Autowired
    private UserRoleService userRoleService;
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
    
    @RequestMapping("/insertUser")
  // @Transactional(rollbackFor=Exception.class)
    //@Transactional
    public String insertUser(){
    	
    	for(int i=0;i<2;i++){
    		User user=new User();
        	user.setPassword("222");
        	user.setUserName("你好"+i);
        	user.setAge(i+1);
        	user.setId(i+1);
        
        	//插入该用户的角色信息
        	for(int j=0;j<3;j++){
        		insertUserRole(i,j);		
        	}
        	userService.inserUser(user);
    	}
    	
    	/*User user=new User();
    	UserRole userRole=new UserRole();
    	userRoleService.insertUserRole(userRole); 
    	
    	userService.inserUser(user);
    	*/
    	
    	return "success";
    	//throw new RuntimeException("抛异常");
    	
    }
    
    //@Transactional
    public int  insertUserRole(int i,int j){
    	UserRole userRole=new UserRole();
		userRole.setUserId(Integer.toString(i));
		userRole.setRoleId(Integer.toString(i+j+5));
		userRole.setDesc("你好");
		return userRoleService.insertUserRole(userRole);  
    }
}
