package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.DemoUser;
import com.example.demo.repository.DemoUserRepo;

@Service
public class DemoUserServiceImpl implements DemoUserService {

	@Autowired
	private DemoUserRepo userRepo;

	@Override
	public List<DemoUser> getAll() {
		return userRepo.findAll();
	}

	@Override
	public String addUserString(DemoUser user) {
		try {
			userRepo.save(user);
			return "Added user successfully";
		} catch (Exception e) {
			return "Error while adding User: " + e.getLocalizedMessage();
		}
	}

	@Override
	public Boolean addUserBoolean(DemoUser user) {
		try {
			userRepo.save(user);
			return true;
		} catch (Exception e) {
			System.err.println(e.getLocalizedMessage());
			return false;
		}
	}

}
