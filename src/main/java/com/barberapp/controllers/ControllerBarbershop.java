package com.barberapp.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barberapp.entities.Barbershop;
import com.barberapp.servicies.barbershop.ServiceBarbershop;

@RestController
@RequestMapping("/barbershop")
public class ControllerBarbershop {
	
	@Autowired private ServiceBarbershop serviceBarbershop;
	
	@GetMapping("hola")
	public String saludo() {
		
		return "Saludo desde controlado barbershop";
	}
	
	/////////////////// BARBERSHOP REGISTRAR   http://localhost:8080/barbershop/save ////////////////
	@PostMapping("/save")
	public ResponseEntity<Barbershop> createBarbershop (@RequestBody Barbershop barbershop){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceBarbershop.save(barbershop));
		
	}
	
	
	///////////////////  CONSULT BARBERSHOP   http://localhost:8080/barbershop/consult/id ////////////////
	@GetMapping("/consult/{id}")
	public ResponseEntity<Optional<Barbershop>> consultBarbershopId (@PathVariable(value = "id") Long id){
		
		Optional<Barbershop> barbershop = serviceBarbershop.findById(id);
		
		if (barbershop.isPresent()) {
			
			return ResponseEntity.ok(barbershop);
		} else {
			return ResponseEntity.notFound().build();
		}
		
	}
	
	
	///////////////////  UPDATE BARBERSHOP   http://localhost:8080/barbershop/update/id ////////////////
	@PutMapping("/update/{id}")
	public ResponseEntity<Barbershop> updateBarbershop (@RequestBody Barbershop newBarbershop, @PathVariable (value = "id") Long id){
		
		Optional<Barbershop> barbershop = serviceBarbershop.findById(id);
		
		if (barbershop.isPresent()) {
			
			barbershop.get().setLocation(newBarbershop.getLocation());
			barbershop.get().setLinkedBarbers(newBarbershop.getLinkedBarbers());
			barbershop.get().setQualification(newBarbershop.getQualification());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceBarbershop.save(barbershop.get()));
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	///////////////////  DELTE BARBERSHOP   http://localhost:8080/barbershop/consult/id ////////////////
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Barbershop> deletebarbershop (@PathVariable(value = "id") Long id){
		
		Optional<Barbershop> barbershop = serviceBarbershop.findById(id);
		
		if (barbershop.isPresent()) {
			
			serviceBarbershop.deleteById(id);
			return ResponseEntity.ok().build();
		} else {
			
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
	/////////////////// CONSULT ALL BARBERSHOP   http://localhost:8080/barbershop/consult/id ////////////////
	@GetMapping("/consultall")
	public List<Barbershop> getAllBarbershop (){
		
		List<Barbershop> barbershops = StreamSupport
				.stream(serviceBarbershop.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return barbershops;
	}
	
	
	
	
}
