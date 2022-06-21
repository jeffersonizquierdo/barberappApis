package com.barberapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barberapp.entities.Customer;
import com.barberapp.servicies.customer.ServiceCustomer;


@RestController
@RequestMapping("customer")
public class ControllerCustomer {
	
	@Autowired(required = true) private ServiceCustomer serviceCustomer;
	
	@GetMapping("/hola")
	public String saludo() {
		
		return "saludo desde controlador customer";
	}
	
	
	 /////////////////// CUSTOMER REGISTRAR   http://localhost:8080/customer/save ////////////////
	@PostMapping("/save")
	public ResponseEntity<Customer> createCustomer (@RequestBody Customer customer){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceCustomer.save(customer));
	}
	
	
	 /////////////////// CONSULT REGISTRAR   http://localhost:8080/customer/consult/id ////////////////
	@GetMapping("/consult/{id}")
	public ResponseEntity<Optional<Customer>> consultCustomerById (@PathVariable(value = "id") Long id){
		
		Optional<Customer> customer = serviceCustomer.findById(id);
		
		if (customer.isPresent()) {
			
			return ResponseEntity.ok(customer);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	/////////////////// CONSULT REGISTRAR   http://localhost:8080/customer/update/id ////////////////
	@PutMapping("/update/{id}")
	public ResponseEntity<Customer> updateCustomer (@RequestBody Customer newCustomer, @PathVariable(value = "id") Long id){
		
		Optional<Customer> customer = serviceCustomer.findById(id);
		
		if (customer.isPresent()) {
			
			customer.get().setAge(newCustomer.getAge());
			customer.get().setGeder(newCustomer.getGeder());
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceCustomer.save(newCustomer));
			
		} else {
			
			return ResponseEntity.notFound().build();
		}
		
	}	
	
	
	/////////////////// DELETE REGISTRAR   http://localhost:8080/customer/delete/id ////////////////
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Customer> deleteCustomer (@PathVariable Long id){
		
		
		if (serviceCustomer.findById(id).isPresent()) {
			
			serviceCustomer.deleteById(id);
			return ResponseEntity.ok().build();
		
		} else {
			
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	/////////////////// CONSULTALL CUSTOMER   http://localhost:8080/customer/delete/id ////////////////
	@GetMapping("/consultall")
	public List<Customer> consultAllCustomers (){
		
		List<Customer> customers = StreamSupport.stream(serviceCustomer.findAll().spliterator(), false).collect(Collectors.toList());
		
		
		return customers;
	}
	

}
