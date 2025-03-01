package assignment6.controller;

/*
 * Assignment-6: Create a Spring MVC Application as per the requirements below: 
This application helps to check the availability of buses. 
a. Bus class properties: busname, location (destination), ticket_price. 
b. Create a form where bus operator can add bus details. And when the form is submitted, request should go to /addbus. Write a method which handles this end point and adds the bus to the database. 
c. Create an endpoint called /buses which user can use to send request to get details of all buses. 
d. When user sends request on /buses , you should retrieve all the existing bus details from the database and return the details. 
e. If the user searches for a bus to a specific location, like /buses/{location}, then buses which goes to that location alone should be returned in response.
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import assignment6.model.Bus;
import assignment6.service.BusService;

@Controller
public class BusController {
	@Autowired
	BusService busService;

	@GetMapping("/showbuses/{location}")
	public String getBusByLocation(@PathVariable("location") String location, Model model) {
		model.addAttribute("buses", busService.getBus(location));
		return "showbus";
	}

	@GetMapping("/showbuses")
	public String getBusesByLocation(@RequestParam(value = "location", required = false) String location, Model model) {
		if (location != null && !location.isEmpty()) {
			model.addAttribute("buses", busService.getBus(location));
		} else {
			model.addAttribute("buses", busService.getBus()); // Fetch all buses if no location is given
		}
		return "showbus";
	}

	@PostMapping("/showbuses/{location}")
	public String getBusByLocation(@ModelAttribute("location") String location, Bus bus) {
		return "redirect:/showbuses/" + location;
	}

	@GetMapping("/addbus")
	public String addBus(Model model) {
		model.addAttribute("bus", new Bus());
		return "addbus";
	}

	@PostMapping("/addbus")
	public String addBus(@ModelAttribute("bus") Bus bus) {
		busService.addBus(bus);
		return "redirect:/showbuses";
	}
}
