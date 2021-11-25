package com.jd.springdemo.rest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jd.springdemo.entity.Customer;
import com.jd.springdemo.exception.CustomerNotFoundException;
import com.jd.springdemo.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerRestController {
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/customers")
	public List<Customer> getCustomers(){
		
		return customerService.getCustomers();
	}
	
	@GetMapping("/customers/{customerId}")
	public Customer getCustomers(@PathVariable int customerId) throws CustomerNotFoundException {
		Optional<Customer> customer=Optional.ofNullable(customerService.getCustomer(customerId));
		if(!customer.isPresent())
		{
			throw new CustomerNotFoundException("Customer not found with id= "+customerId);
		}
		return customer.get();
		
	}
	
	@PostMapping("/customers")
	public Customer addCustomer(@RequestBody Customer customer) {
		customer.setId(0);
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@PutMapping("/customers")
	public Customer updateCustomer(@RequestBody Customer customer) {
		
		customerService.saveCustomer(customer);
		return customer;
	}
	
	@DeleteMapping("/customers/{customerId}")
	public String deleteCustomer(@PathVariable int customerId) {
		Optional<Customer> customer=Optional.ofNullable(customerService.getCustomer(customerId));
		if(!customer.isPresent()) {
			throw new CustomerNotFoundException("Customer with id ="+customerId+" does not exist!!");
		}	
		customerService.deleteCustomer(customerId);
		return "Deleted customer with customerId="+customerId ;
		
	}
	
	

}
