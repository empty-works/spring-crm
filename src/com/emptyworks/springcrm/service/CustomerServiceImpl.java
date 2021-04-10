package com.emptyworks.springcrm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emptyworks.springcrm.dao.CustomerDAO;
import com.emptyworks.springcrm.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	// Need to inject customer DAO
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

}
