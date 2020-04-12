package com.imcode.sys.entity;
/**
 * 该表为继承用户表，包括用户表所有属性+角色名称
 * @author Administrator
 *
 */
public class User_Role extends User {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "User_Role [name=" + name + "]";
	}
}
