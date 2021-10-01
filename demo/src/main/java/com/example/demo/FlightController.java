package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1.0/flight")
@RestController
public class FlightController {
	@Autowired
	FlightService flightService;
	ArrayList<User> users = new ArrayList<>();
	@PostMapping("/airline/register")
	String register(@RequestBody User user) {
		users.add(user);
		return "Registered Successfully!!";
	}	
	
	@GetMapping("/")
	ArrayList getDetails() {
		return users;
	}
	
	@PostMapping("/airline/inventory/add")
	String addEntry(@RequestBody Inventory inventory) {
		System.out.println(inventory.getFlightNumber());
		System.out.println(inventory.getAirline());
		flightService.save(inventory);
		System.out.println(inventory.getAirline());
		return "Flight details added successfully!!";
	}
	
	@PostMapping("/search")
	List<Inventory> FlightSearch(@RequestBody Inventory inventory){
		return flightService.searchFlight(inventory);
	}	
	
	
}
