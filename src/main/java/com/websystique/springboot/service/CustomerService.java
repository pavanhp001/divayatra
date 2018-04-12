package com.websystique.springboot.service;

import java.util.List;

import com.websystique.springboot.model.Customer;

public interface CustomerService {
	
	Customer findById(Long id);

	//Customer findByName(String name);

	void saveCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomerById(Long id);

	void deleteAllCustomers();

	List<Customer> findAllCustomers();

	boolean isCustomerExist(Customer customer);

}
