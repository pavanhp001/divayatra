package com.websystique.springboot.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.websystique.springboot.model.Customer;
import com.websystique.springboot.service.CustomerService;
import com.websystique.springboot.util.CustomErrorType;

@RestController
@RequestMapping("/customer")
public class CustomerApiController {
	
	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	CustomerService CustomerService; //Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All Customers---------------------------------------------

	@RequestMapping(value = "/listAllCustomers/", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> listAllCustomers() {
		List<Customer> Customers = CustomerService.findAllCustomers();
		if (Customers.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Customer>>(Customers, HttpStatus.OK);
	}

	// -------------------Retrieve Single Customer------------------------------------------

	@RequestMapping(value = "/getCustomer/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getCustomer(@PathVariable("id") long id) {
		logger.info("Fetching Customer with id {}", id);
		Customer Customer = CustomerService.findById(id);
		if (Customer == null) {
			logger.error("Customer with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Customer with id " + id 
					+ " not found"), HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(Customer, HttpStatus.OK);
	}

	// -------------------Create a Customer-------------------------------------------

	@RequestMapping(value = "/createCustomer/", method = RequestMethod.POST)
	public ResponseEntity<?> createCustomer(@RequestBody Customer Customer, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Customer : {}", Customer);

		/*if (CustomerService.isCustomerExist(Customer)) {
			logger.error("Unable to create. A Customer with name {} already exist", Customer.getFirst_name()+" "+Customer.getLast_name());
			return new ResponseEntity(new CustomErrorType("Unable to create. A Customer with name " + 
					Customer.getFirst_name()+" "+Customer.getLast_name() + " already exist."),HttpStatus.CONFLICT);
		}*/
		CustomerService.saveCustomer(Customer);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/api/Customer/{id}").buildAndExpand(Customer.getId()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

	// ------------------- Update a Customer ------------------------------------------------

	@RequestMapping(value = "/updateCustomer/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateCustomer(@PathVariable("id") long id, @RequestBody Customer Customer) {
		logger.info("Updating Customer with id {}", id);

		Customer currentCustomer = CustomerService.findById(id);

		if (currentCustomer == null) {
			logger.error("Unable to update. Customer with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to upate. Customer with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}

		currentCustomer.setArrive_date(Customer.getArrive_date());
		currentCustomer.setCar_no(Customer.getCar_no());
		currentCustomer.setEmail(Customer.getEmail());
		currentCustomer.setEmergency_contact_no(Customer.getEmergency_contact_no());
		currentCustomer.setFirst_name(Customer.getFirst_name());
		currentCustomer.setGender(Customer.getGender());
		currentCustomer.setHave_car(Customer.getHave_car());
		currentCustomer.setLast_name(Customer.getLast_name());
		currentCustomer.setPhone_no(Customer.getPhone_no());
		currentCustomer.setRoom_id(Customer.getRoom_id());
		
		CustomerService.updateCustomer(currentCustomer);
		return new ResponseEntity<Customer>(currentCustomer, HttpStatus.OK);
	}

	// ------------------- Delete a Customer-----------------------------------------

	@RequestMapping(value = "/deleteCustomer/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id) {
		logger.info("Fetching & Deleting Customer with id {}", id);

		Customer Customer = CustomerService.findById(id);
		if (Customer == null) {
			logger.error("Unable to delete. Customer with id {} not found.", id);
			return new ResponseEntity(new CustomErrorType("Unable to delete. Customer with id " + id + " not found."),
					HttpStatus.NOT_FOUND);
		}
		CustomerService.deleteCustomerById(id);
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	}

	// ------------------- Delete All Customers-----------------------------

	@RequestMapping(value = "/deleteAllCustomers/", method = RequestMethod.DELETE)
	public ResponseEntity<Customer> deleteAllCustomers() {
		logger.info("Deleting All Customers");

		CustomerService.deleteAllCustomers();
		return new ResponseEntity<Customer>(HttpStatus.NO_CONTENT);
	}

}
