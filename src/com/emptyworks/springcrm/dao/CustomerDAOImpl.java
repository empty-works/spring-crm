package com.emptyworks.springcrm.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.emptyworks.springcrm.entity.Customer;

// Need this so Hibernate can component scan and find this repository and also handle 
// exception translation.
@Repository
public class CustomerDAOImpl implements CustomerDAO {

	// Need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	// Need to inject 
	@Override
	public List<Customer> getCustomers() {
		
		// Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Create a query...sort by last name 
		// As of Spring 5.2, import org.hibernate.query.Query
		Query<Customer> theQuery = 
				currentSession.createQuery("from Customer order by lastName", 
											Customer.class);
		
		// Execute query and result list
		List<Customer> customers = theQuery.getResultList();
		
		// Return the results
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		
		// Get current Hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Save the customer to the DB
		currentSession.save(theCustomer);
	}

	@Override
	public Customer getCustomer(int theId) {

		// Get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// Retrieve/read from the database using the primary key
		Customer theCustomer = currentSession.get(Customer.class, theId);
		
		return theCustomer;
	}
}
