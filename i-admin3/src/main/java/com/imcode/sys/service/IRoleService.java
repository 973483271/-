package com.imcode.sys.service;


import org.apache.ibatis.annotations.Param;

import com.imcode.sys.entity.DeptRole;
import com.imcode.sys.entity.Role;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author jack
 * @since 2019-11-04
 */
public interface IRoleService extends IService<Role> {
	
	//自定义分页查询
	 IPage<DeptRole> selectRoleDeptPage(Page<DeptRole> page,Role role) ;
}
