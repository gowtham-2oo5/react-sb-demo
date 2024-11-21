package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.DemoUser;
import com.example.demo.service.DemoUserService;

@RestController
@RequestMapping("/api/demo")
public class MainController {

	@Autowired
	private DemoUserService userService;

	@GetMapping
	public ResponseEntity<?> getAllUsers() {
		try {
			List<DemoUser> users = userService.getAll();
			return ResponseEntity.ok().body(users);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}

	@PostMapping("/v1")
	public ResponseEntity<?> postUserString(@RequestBody DemoUser user) {
		try {
			String response = userService.addUserString(user);
			if (response.equals("Added user successfully")) {
				return ResponseEntity.ok().body(response);
			} else {
				return ResponseEntity.badRequest().body(response);
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}

	@PostMapping("/v2")
	public ResponseEntity<?> postUserBoolean(@RequestBody DemoUser user) {
		try {
			Boolean response = userService.addUserBoolean(user);
			if (response) {
				return ResponseEntity.ok().body("user added");
			} else {
				return ResponseEntity.badRequest().body("Error while adding user");
			}
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getLocalizedMessage());
		}
	}
	

}
