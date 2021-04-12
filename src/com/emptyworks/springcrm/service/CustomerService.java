package com.emptyworks.springcrm.service;

import java.util.List;

import com.emptyworks.springcrm.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public Customer getCustomer(int theId);
}
