package com.barberapp.servicies.customer;

import java.util.List; 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barberapp.entities.Customer;
import com.barberapp.repositories.RepositoryCustomer;

@Service
public class ServiceCustomerImpl implements ServiceCustomer{
	
	@Autowired(required = true) private RepositoryCustomer repositoryCustomer;

	@Override
	@Transactional(readOnly = true)
	public List<Customer> findAll() {
		
		return repositoryCustomer.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Customer> findAll(Pageable pageable) {
		
		return repositoryCustomer.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Customer> findById(Long id) {
		
		return repositoryCustomer.findById(id);
	}

	@Override
	public Customer save(Customer customer) {
		
		return repositoryCustomer.save(customer);
	}

	
	@Override
	public void deleteById(Long id) {
		repositoryCustomer.deleteById(id);
	}

}
