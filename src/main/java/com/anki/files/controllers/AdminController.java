package com.anki.files.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anki.files.common.RestObject;
import com.anki.files.pojo.Admin;
import com.anki.files.pojo.Qa;
import com.anki.files.pojo.Users;
import com.anki.files.service.AdminService;

import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/ankiAdmin")
public class AdminController {
	@Autowired
	AdminService service;
	
	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	RestObject login(Admin admin, @ApiIgnore HttpSession session) {
		return service.login(admin, session);
	}
	
	@RequestMapping(value="/logOut.do", method=RequestMethod.POST)
	RestObject logOut(@ApiIgnore HttpSession session) {
		session.invalidate();
		return RestObject.Ok("Logged out successfully", null);
	}
	
	@RequestMapping(value="/showAllUsers.do", method=RequestMethod.POST)
	RestObject showAllUsers(Users user) {
		return service.showAllUsers(user);
	}
	
	
	@RequestMapping(value="/feedBack.do", method=RequestMethod.POST)
	RestObject feedBack(Qa response,HttpSession session) {
		return service.feedBack(response, session);
	}
	
	@RequestMapping(value="/inbox.do", method=RequestMethod.POST)
	RestObject inbox(Qa message,HttpSession session) {
		return service.inbox(message, session);
	}
}
