package com.imcode.sys.entity;
/**
 * 存储角色所有信息+部门名称信息
 * @author Administrator
 *
 */
public class DeptRole extends Role{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	private String deptName;

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "DeptRole [deptName=" + deptName + "]";
	}
}
