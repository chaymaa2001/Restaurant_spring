package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.User;
import com.example.demo.service.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {
@Autowired
private UserService service;
@PostMapping("/save")
public User save(@RequestBody User o) {
	return service.save(o);
}
@GetMapping("/all")
	public List<User> findAll() {
		return service.findAll();
	}
@GetMapping("/find/{id}")
public User findById(@PathVariable String id) {
	return service.findById(Integer.parseInt(id));
}
@PostMapping("/update")
public void update(@RequestBody User o) {
	service.update(o);
}
@DeleteMapping("/delete")
public void delete(@RequestBody User o) {
	service.delete(o);
}



}
