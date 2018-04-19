package com.wenyue.blog.home.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wenyue.blog.home.entity.User;
import com.wenyue.blog.home.service.Userservice;
import com.wenyue.common.GlobleResult;

@Controller
public class BaseController {

	@Resource
	private Userservice userservice;
	
	@GetMapping(value = "")
	public String home() {
		System.out.println("---------------");
		return "portal/home";
	}
	
	@GetMapping(value = "/list")
	public @ResponseBody GlobleResult queryUserList() {
		List<User> data = userservice.getUserList();
		return GlobleResult.success(data);
	}
	
}