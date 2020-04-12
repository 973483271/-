package com.imcode.sys.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imcode.common.model.R;
import com.imcode.sys.entity.Dept;
import com.imcode.sys.entity.Role;
import com.imcode.sys.service.IDeptService;
import com.imcode.sys.service.IRoleService;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jack
 * @since 2019-12-26
 */
@Controller
@RequestMapping("/sys/dept")
public class DeptController {
	@Autowired
	private IDeptService deptService;
	@Autowired
	private IRoleService roleService;
	/**
	 * 跳转到列表页面
	 */
	@GetMapping
	@RequiresPermissions("sys:dept:list")
	public String list(){
		return "sys/dept_list";
	}
	
	/**
	 * 获取列表数据
	 */
	@GetMapping("data")
	@ResponseBody
	@RequiresPermissions("sys:dept:list")
	public R data(String deptname){
		QueryWrapper<Dept> wrapper = new QueryWrapper<Dept>();
		if(!StringUtils.isEmpty(deptname)){
			try {
				wrapper.like("dept_name",new String(deptname.getBytes("ISO8859-1"), "utf-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		}
		//获取数据集
		List<Dept> rows = deptService.list(wrapper);
		System.out.println("++++++"+rows);
		//获取数据条数
		Integer total = deptService.count(wrapper);
		return R.ok()
				 .put("total",total)
	              .put("rows", rows);
	}
	/**
	 * 跳转到新增页面
	 */
	@GetMapping("/add")
	@RequiresPermissions("sys:dept:add")
	public String add(){
		return "sys/dept_add";
	}
	/**
	 * 新增部门
	 */
	@PostMapping("/add")
		@RequiresPermissions("sys:dept:add")
		@ResponseBody
		public R add(Dept dept){
			deptService.save(dept);
			return R.ok();
		}
	/**
	 *删除
	 */
	@GetMapping("/delete/{id}")
	@RequiresPermissions("sys:dept:delete")
	@ResponseBody
	@Transactional   //事务回滚
	public R delete(@PathVariable Integer id){
		//根据部门id删除部门
		deptService.removeById(id);
		/**
		 * 删除部门下所有角色
		 */
		//根据部门id删除角色信息
		QueryWrapper<Role> wrapper =  new QueryWrapper<Role>();
		wrapper.eq("dept_Id", id);
		 roleService.remove(wrapper);
		//删除
		return R.ok() ;
	}
	/**
	 * 批量删除
	 */
	@PostMapping("/deletebatch")
	@ResponseBody
	@RequiresPermissions("sys:dept:delete")
	@Transactional
	public R delete(@RequestBody List<Integer> ids){
		//根据id删除对应的部门
		deptService.removeByIds(ids);
		//根据部门id删除对应的角色信息
		for(Integer id : ids){
			QueryWrapper<Role> wrapper = new QueryWrapper<Role>();
			wrapper.eq("dept_Id", id);
			roleService.remove(wrapper);
		}
		return R.ok();
	}
	/**
	 * 跳转到更新页面
	 */
	@GetMapping("/update/{id}")
	@RequiresPermissions("sys:dept:update")
	public String update(@PathVariable Integer id,Model model){
		model.addAttribute("dept", deptService.getById(id));
		return "sys/dept_update";
	}
	/**
	 * 更新
	 */
	@PostMapping("/update")
	@RequiresPermissions("sys:dept:update")
	@ResponseBody
	public R update(Dept dept){
		deptService.updateById(dept);
		return R.ok();
	}
}
