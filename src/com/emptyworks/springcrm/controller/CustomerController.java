package com.emptyworks.springcrm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.emptyworks.springcrm.dao.CustomerDAO;
import com.emptyworks.springcrm.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	// Need to inject the customer DAO
	@Autowired
	private CustomerDAO customerDAO;

	@RequestMapping(path="/list", method=RequestMethod.GET)
	// Remember: can also use @GetMapping("/list") instead!!!!
	public String listCustomers(Model theModel) {
		
		// Get customers from the DAO
		List<Customer> theCustomers = customerDAO.getCustomers();
		
		// Add the customers to the model
		theModel.addAttribute("customers", theCustomers);
		
		return "list-customers";
	}
}
