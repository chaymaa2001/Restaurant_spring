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
import com.example.demo.entities.Ville;
import com.example.demo.entities.Zone;
import com.example.demo.service.VilleService;

@RestController
@RequestMapping("api/villes")
public class VilleController {
	@Autowired
	private VilleService service;

	@PostMapping("/save")
	public Ville save(@RequestBody Ville o) {
		return service.save(o);
	}
    @GetMapping("/all")
	public List<Ville> findAll() {
		return service.findAll();
	}
    
    @GetMapping("/{villeNom}/zones")
	public List<Zone> findByZone(@PathVariable String villeNom) {
    	for(Ville ville : service.findAll()) {
    		if(ville.getNom().equals(villeNom)) {
    			return ville.getZones();
    		}
    	}
		return null;
	}
    
    @GetMapping("/{villeNom}/zones/{zoneNom}/restaurants")
   	public List<Restaurant> findRestaurantByZone(@PathVariable String villeNom, @PathVariable String zoneNom) {
    	for(Zone zone : this.findByZone(villeNom)) {
    		if(zone.getNom().equals(zoneNom)) {
    			return zone.getRestaurants();
    		}
    	}
   		return null;
   	}
    
    @GetMapping("/{villeNom}/zones/{zoneNom}/restaurants/{id}")
   	public Restaurant findRestaurantById(@PathVariable String villeNom, @PathVariable String zoneNom, @PathVariable String id) {
    	for(Restaurant restaurant : this.findRestaurantByZone(villeNom, zoneNom)) {
    		if(restaurant.getId() == Integer.parseInt(id)) {
    			return restaurant;
    		}
    	}
   		return null;
   	}

	@GetMapping("/find/{id}")
	public Ville findById(@PathVariable String id) {
		return service.findById(Integer.parseInt(id));
	}
    @PostMapping("/update")
	public void update(@RequestBody Ville o) {
		service.update(o);
	}
	
	@DeleteMapping("/delete")
	public void delete(@RequestBody Ville o) {
		service.delete(o);
	}
	
	
}
