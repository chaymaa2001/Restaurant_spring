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

import com.example.demo.entities.Restaurant;

import com.example.demo.service.RestaurantService;

@RestController
@RequestMapping("api/restaurants")
public class RestaurantController {
	@Autowired(required = true)
	private RestaurantService service;

	@PostMapping("/save")
	public Restaurant save(@RequestBody Restaurant o) {
		return service.save(o);
	}

	@GetMapping("/all")
	public List<Restaurant> findAll() {
		return service.findAll();
	}

	@GetMapping("/find/{id}")
	public Restaurant findById(@PathVariable String id) {
		return service.findById(Integer.parseInt(id));
	}

	@PostMapping("/update")
	public void update(@RequestBody Restaurant o) {
		service.update(o);
	}

	@DeleteMapping("/delete")
	public void delete(@RequestBody Restaurant o) {
		service.delete(o);
	}
}
