package com.shiro.test;


import javax.annotation.Resource;
import javax.sound.midi.Soundbank;

import com.imcode.common.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.imcode.sys.entity.User;
import com.imcode.sys.mapper.UserMapper;
import com.imcode.sys.mapper.UserRoleMapper;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-config.xml")
public class ShiroTest {
	@Autowired
	  private UserMapper userMapper;
	@Resource
	private UserRoleMapper userRoleMapper;
	@Test
	public void test01(){
		System.out.println("加密"+ MD5Util.md5_public_salt("123456"));

		System.out.println(MD5Util.md5_private_salt("123456", "98C69A2446384F22B5EFC7874095AC69"));
		QueryWrapper<User> param = new QueryWrapper<>();
        param.eq("username","admin");
        User user = userMapper.selectOne(param);
	}
}
