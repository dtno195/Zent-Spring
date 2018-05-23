package com.zent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zent.service.IUserService;

@Controller()
public class UserController {
	@Autowired
	private IUserService userService;
	
	
	public IUserService getUserService() {
		return userService;
	}


	public void setUserService(IUserService userService) {
		this.userService = userService;
	}


	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public  String getCallHistory(){
		return "user";
	}
}
