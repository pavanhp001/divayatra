package com.websystique.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springboot.model.Customer;
import com.websystique.springboot.repositories.CustomerRepository;

@Service("customerService")
@Transactional
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository customerRepository;

	public Customer findById(Long id) {
		return customerRepository.findOne(id);
	}

	/*public Customer findByName(String name) {
		return customerRepository.findByName(name);
	}*/

	public void saveCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public void updateCustomer(Customer customer){
		saveCustomer(customer);
	}

	public void deleteCustomerById(Long id){
		customerRepository.delete(id);
	}

	public void deleteAllCustomers(){
		customerRepository.deleteAll();
	}

	public List<Customer> findAllCustomers(){
		return customerRepository.findAll();
	}

	public boolean isCustomerExist(Customer customer) {
		return findById(customer.getId()) != null;
	}

}