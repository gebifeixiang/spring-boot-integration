package org.spring.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.spring.web.entity.User;
import org.springframework.stereotype.Component;

/**
*
* 项目名称：spring-web
* 类名称：UserMapper
* 类描述：
* 创建人：john
* 创建时间：2018年7月28日 上午11:57:18
* 修改人：john
* 修改时间：2018年7月28日 上午11:57:18
* 修改备注：
* @version
*
*/
//@Mapper
//@Component


public interface UserMapper {
	/*
	 * 用户新增
	 */
   public int insertUser(User user);
   
   public User selectUserById(Integer id);
   
   public int updateUser(User user);
}
