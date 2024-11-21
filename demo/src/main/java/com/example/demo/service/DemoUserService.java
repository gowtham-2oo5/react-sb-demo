package com.example.demo.service;

import java.util.List;

import com.example.demo.model.DemoUser;

public interface DemoUserService {

	// Get Users
	List<DemoUser> getAll();

	// Post user (Create new user) -> String msg, HttpResponseCode, Boolean
	String addUserString(DemoUser user);

	Boolean addUserBoolean(DemoUser user);
}
