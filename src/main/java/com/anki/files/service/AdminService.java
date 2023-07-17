package com.anki.files.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anki.files.common.RestObject;
import com.anki.files.mapper.AdminMapper;
import com.anki.files.pojo.Admin;
import com.anki.files.pojo.Qa;
import com.anki.files.pojo.Users;

@Service
public class AdminService {
	@Autowired
	AdminMapper adminMapper;
	
	public RestObject login(Admin admin,HttpSession session) {
		Admin result=adminMapper.login(admin.getEmail());
		if(result!=null) {
			if(admin.getPassword().equals(result.getPassword())) {
				result.setPassword(null);
				session.setAttribute("admin_id", result.getId());
				return RestObject.Ok("Logged in successfully", null);
			}else {
				return RestObject.Error("The pasword is incorrect");
			}
		}else {
			return RestObject.Error("The account does not exist");
		}
	}
	
	
	public RestObject showAllUsers(Users user) {
		ArrayList<Users>result=adminMapper.showAllUsers();
	
		if(result!=null) {
			user.setCount(result.size());
			return RestObject.Ok("All the users have been obtained", result);
		}else {
			return RestObject.Error("could not get all the user");
		}
	}
	
	public RestObject inbox(Qa message,HttpSession session) {
		//int Qa_id=(int)session.getAttribute("Qa_id");
		ArrayList<Qa>result=adminMapper.inbox();
		if(result!=null) {
			return RestObject.Ok("You have new messages", result);
		}else {
			return RestObject.Error("No new messages");
		}
	}
	
	public RestObject feedBack(Qa response,HttpSession session ) {
		//int Qa_id=(int)session.getAttribute("Qa_id");
		int admin_id=(int)session.getAttribute("admin_id");
		System.out.println("feed back method running "+ response);
		int result=adminMapper.feedBack(admin_id,response.getAnswers(), response.getId());
		if(result==1) {
			return RestObject.Ok("message sent to the user", result);
		}else {
			return RestObject.Error("message was not sent");
		}
	}
	
}
