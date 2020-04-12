package com.imcode.sys.mapper;


import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.imcode.sys.entity.DeptRole;
import com.imcode.sys.entity.Role;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author jack
 * @since 2019-11-04
 */
public interface RoleMapper extends BaseMapper<Role> {
	/**
	 * 自定义多表联合查询并分页
	 * @param page
	 * @param state
	 * @return
	 */
	IPage<DeptRole> selectPageVo(IPage<DeptRole> page, @Param("role") Role role);
}
