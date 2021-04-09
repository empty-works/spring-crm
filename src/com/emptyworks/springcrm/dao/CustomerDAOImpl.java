package com.emptyworks.springcrm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.emptyworks.springcrm.entity.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	// Need to inject 
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		
		// Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query 
		// As of Spring 5.2, import org.hibernate.query.Query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer", Customer.class);
		
		// Execute query and result list
		List<Customer> customers = theQuery.getResultList();
		
		// Return the results
		return customers;
	}
}
