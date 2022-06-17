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

import com.barberapp.entities.User;
import com.barberapp.service.user.ServiceUser;

@RestController
@RequestMapping("username")
public class ControllerUser {
	
	@Autowired(required = true) private ServiceUser serviceUser;
	
	@GetMapping("hola")
	public String saludo() {
		
		return "saludo desde controlador user";
	}
	
	
	 /////////////////// USER REGISTRAR   http://localhost:8080/username/save ////////////////
	@PostMapping("/save")
	public ResponseEntity<User> createUsername (@RequestBody User username){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceUser.save(username));
	}
	
	
	/////////////////// CONSULT USER   http://localhost:8080/username/consult ////////////////
	@GetMapping("/consult/{id}")
	public ResponseEntity<Optional<User>> consultUsernameId (@PathVariable(value = "id") Long id){
		
		Optional<User> user = serviceUser.findById(id);
		
		if (user.isPresent()) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	/////////////////// UPDATE USER   http://localhost:8080/username/update ////////////////
	@PutMapping("/update/{id}")
	public ResponseEntity<User> updateUser (@RequestBody User newUser, @PathVariable(value = "id") Long id){
		
		Optional<User> user = serviceUser.findById(id);
		if (user.isPresent()) {
			
			user.get().setNickname(newUser.getNickname());
			user.get().setPassword(newUser.getPassword());
			user.get().setCellphoneNumber(newUser.getCellphoneNumber());
			user.get().setCity(newUser.getCity());			
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceUser.save(user.get()));
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	/////////////////// DELETE USER   http://localhost:8080/username/delete ////////////////
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable(value = "id")  Long id){
		
		
		if(serviceUser.findById(id).isPresent()) {
			
			serviceUser.deleteById(id);
			return ResponseEntity.ok().build();
			
		} else {
			
			return ResponseEntity.notFound().build();
		}		
	}
	
	/////////////////// CONSULT ALL USER   http://localhost:8080/username/consultall ///////////////	
	@GetMapping("/consultall")
	public  List<User> consultAllUsers(){
		
		
		List<User> users = StreamSupport
				.stream(serviceUser.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return users;
	}
	
	 
}
