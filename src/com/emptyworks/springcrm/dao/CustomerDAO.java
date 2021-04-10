package com.emptyworks.springcrm.dao;

import java.util.List;

import com.emptyworks.springcrm.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
}
