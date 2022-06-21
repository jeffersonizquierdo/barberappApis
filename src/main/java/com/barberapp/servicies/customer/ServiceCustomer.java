package com.barberapp.servicies.customer;

 
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.barberapp.entities.Customer;

public interface ServiceCustomer {
	
	public List<Customer> findAll();
	
	public Page<Customer> findAll(Pageable pageable);
	
	public Optional<Customer> findById (Long id);
	
	public Customer save (Customer customer);
	
	public void deleteById(Long id);

}
