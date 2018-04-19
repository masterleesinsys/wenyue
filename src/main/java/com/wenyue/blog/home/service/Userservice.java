package com.wenyue.blog.home.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.wenyue.blog.home.dao.UserDao;
import com.wenyue.blog.home.entity.User;

@Service
public class Userservice {

	@Resource
	private UserDao userDao;
	
	/** 列出所有用戶 */
	public List<User> getUserList() {
		return userDao.listAll();
	}

	
	
}