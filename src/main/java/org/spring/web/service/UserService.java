package org.spring.web.service;

import org.spring.web.entity.User;
import org.springframework.stereotype.Service;

/**
*
* 项目名称：spring-web
* 类名称：UserService
* 类描述：
* 创建人：john
* 创建时间：2018年7月28日 上午11:52:50
* 修改人：john
* 修改时间：2018年7月28日 上午11:52:50
* 修改备注：
* @version
*
*/


public interface UserService {
   public int inserUser(User user);
   
   public User selectUserById(Integer id);
   
   public int updateUser(User user);
   
   public String getUser();

}
