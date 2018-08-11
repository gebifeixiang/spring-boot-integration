package org.spring.web.service.serviceImpl;

import org.spring.web.entity.UserRole;
import org.spring.web.mapper.UserRoleMapper;
import org.spring.web.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
*
* 项目名称：spring-web
* 类名称：UserRoleServiceImpl
* 类描述：
* 创建人：john
* 创建时间：2018年8月7日 下午5:53:46
* 修改人：john
* 修改时间：2018年8月7日 下午5:53:46
* 修改备注：
* @version
*
*/
@Service
public class UserRoleServiceImpl  implements UserRoleService{
	
	@Autowired
	private UserRoleMapper userRoleMapper;
	@Transactional()
	public int insertUserRole(UserRole userRole) {
		/*userRole.setUserId("111");
		userRole.setRoleId("999");
		userRole.setDesc("uuuu");*/
		
		 userRoleMapper.insertUserRole(userRole);
		 
		 
		return 1;
		//throw new RuntimeException("抛异常");

	}

}
