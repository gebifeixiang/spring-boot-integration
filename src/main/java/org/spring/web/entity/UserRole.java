package org.spring.web.entity;

/**
 *
 * 项目名称：spring-web 类名称：UserRole 类描述： 创建人：john 创建时间：2018年8月7日 下午5:42:38 修改人：john
 * 修改时间：2018年8月7日 下午5:42:38 修改备注：
 * 
 * @version
 *
 */
public class UserRole {
	private String userId;
	private String roleId;
	private String desc;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
