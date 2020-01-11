package com.capgemini.moduletest3.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.moduletest3.dto.UserInfo;
import com.capgemini.moduletest3.dto.UserResponse;
import com.capgemini.moduletest3.service.UserSevice;
@RestController
public class UserController {
	@Autowired
	private UserSevice userService;
	@PostMapping(path="/register",produces= MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_VALUE)
	public UserResponse register(@RequestBody UserInfo userInfo) {
		UserResponse response= new UserResponse();
		if(userService.registerUser(userInfo)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee registered");

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Email is already present");
		}
		return response;
	}

	
	@PostMapping(path="/login", produces= MediaType.APPLICATION_JSON_VALUE, consumes=MediaType.APPLICATION_JSON_VALUE)
	public  UserResponse login(@RequestBody UserInfo userInfo) {
		UserInfo userInfo2= userService.loginUser(userInfo.getEmail(), userInfo.getPassword());

		UserResponse response= new UserResponse();
		if(userInfo2!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee found for the credentials");
			response.setUserInfo(Arrays.asList(userInfo2));
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("invalid credentials");
		}
		return response;
	}
	
	@PutMapping(path="/change-password",produces= MediaType.APPLICATION_JSON_VALUE)
	public UserResponse changePassword(@RequestBody UserInfo userInfo) {
		UserResponse response= new UserResponse();
		if(userService.changePassword(userInfo.getId(), userInfo.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("password changed");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("failed to change password");
		}
		return response;
	}
}



