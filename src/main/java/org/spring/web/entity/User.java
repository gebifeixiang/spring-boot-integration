package org.spring.web.entity;

import java.io.Serializable;

/**
 *
 * 项目名称：spring-web 类名称：User 类描述： 创建人：john 创建时间：2018年7月28日 上午11:55:16 修改人：john
 * 修改时间：2018年7月28日 上午11:55:16 修改备注：
 * 
 * @version
 *
 */
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int id;
	private int age;
	private String passWord;
	private String userName;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return passWord;
	}

	public void setPassword(String passWord) {
		this.passWord = passWord;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String toString(){
		return id+","+age+","+passWord+","+userName;
	}

}
