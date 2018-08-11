package org.spring.web.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.spring.web.entity.UserRole;

/**
*
* 项目名称：spring-web
* 类名称：UserRoleMapper
* 类描述：
* 创建人：john
* 创建时间：2018年8月7日 下午5:42:22
* 修改人：john
* 修改时间：2018年8月7日 下午5:42:22
* 修改备注：
* @version
*
*/
@Mapper
public interface UserRoleMapper {
	
	public int insertUserRole(UserRole userRole);
	
	public  int deleteUserRole(UserRole userRole);

}
