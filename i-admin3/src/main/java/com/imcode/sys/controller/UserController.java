package com.imcode.sys.controller;


import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imcode.common.model.R;
import com.imcode.sys.entity.Role;
import com.imcode.sys.entity.User;
import com.imcode.sys.entity.UserRole;
import com.imcode.sys.entity.User_Role;
import com.imcode.sys.service.IDeptService;
import com.imcode.sys.service.IRoleService;
import com.imcode.sys.service.IUserRoleService;
import com.imcode.sys.service.IUserService;

/**
 * <p>
 * 系统用户 前端控制器
 * </p>
 *
 * @author jack
 * @since 2019-10-31
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private IUserRoleService userRoleService;
    @Autowired
    private IDeptService deptService;
    @Autowired
    private IRoleService roleService;
    /**
     * 跳转到列表页面
     *
     * @return
     */
    @GetMapping
    @RequiresPermissions("sys:user:list")
    public String list() {
        return "sys/user_list";
    }

    /**
     * 获取列表数据
     *
     * @param username
     * @return
     */
    @GetMapping("/data")
    @ResponseBody
    @RequiresPermissions("sys:user:list")
    public R data(String username) {
    	String userName = null;
    	if(!StringUtils.isEmpty(username)){
    		try {
    		userName = ("%"+new String(username.getBytes("ISO8859-1"), "utf-8")+"%");
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
    	}
    	List<User_Role> rows = userService.getUser_Role(userName);
	      // 查询满足条件的总记录数
	      return R.ok()
              .put("total",rows.size())
              .put("rows", rows);
        }
    /**
     * 跳转到新增页面
     *
     * @return
     */
    @RequiresPermissions("sys:user:add")
    @GetMapping("/add")
    public String add() {
        return "sys/user_add";
    }

    /**
     * 新增
     *
     * @param user
     * @return
     */
    @PostMapping("/add")
    @ResponseBody
    @RequiresPermissions("sys:user:add")
    public R add(User user) {
        userService.save(user);
        return R.ok();
    }


    /**
     * 跳转到更新页面
     *
     * @return
     */
    @GetMapping("/update/{id}")
    @RequiresPermissions("sys:user:update")
    public String update(@PathVariable Integer id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "sys/user_update";
    }

    /**
     * 更新
     *
     * @param user
     * @return
     */
    @PostMapping("/update")
    @ResponseBody
    @RequiresPermissions("sys:user:update")
    public R update(User user) {
        userService.updateById(user);
        return R.ok();
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    @ResponseBody
    @RequiresPermissions("sys:user:delete")
    public R delete(@PathVariable Integer id) {
        userService.removeById(id);
        return R.ok();
    }


    /**
     * 批量删除
     * @param ids
     * @return
     */
    @PostMapping("/deletebatch")
    @ResponseBody
    @RequiresPermissions("sys:user:delete")
    public R deletebatch(@RequestBody List<Integer> ids) {
        userService.removeByIds(ids);
        return R.ok();
    }

    /**
     * 跳转到给用户分配角色的页面
     *
     * @param userId
     * @return
     */
    @GetMapping("/assign/role/{userId}")
    @RequiresPermissions("sys:user:assign:role")
    public String assignRole(@PathVariable Integer userId, Model model) {
        List<UserRole> userRoleList = userRoleService.getByUserId(userId);
        System.out.println("--------ahha----"+userRoleList);
        model.addAttribute("userRoleList", userRoleList);
        model.addAttribute("userId", userId);
        return "sys/assign_role";
    }

    /**
     * 给用户分配角色
     *
     * @param userId
     * @return
     */
    @PostMapping("/assign/role")
    @ResponseBody
    @RequiresPermissions("sys:user:assign:role")
    public R assignRole(Integer userId,
                        @RequestParam(name = "roleId",required = false) List<Integer> roleIdList) {
    	//根据角色id获取角色信息
    	Role role  = roleService.getById(roleIdList.get(0));
    	//根据用户id获取用户信息
    	User user = userService.getById(userId);
    	//设置用户所属部门id
    	user.setDeptId(role.getDeptId());
    	//更新用户信息
    	userService.updateById(user);
    	userRoleService.save(userId,roleIdList);
        return R.ok();
    }
}
