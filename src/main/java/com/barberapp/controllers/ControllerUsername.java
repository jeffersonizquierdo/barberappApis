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

import com.barberapp.entities.Username;
import com.barberapp.service.username.ServiceUsername;

@RestController
@RequestMapping("username")
public class ControllerUsername {
	
	@Autowired(required = true) private ServiceUsername serviceUsername;
	
	@GetMapping("hola")
	public String saludo() {
		
		return "saludo desde controlador username";
	}
	
	
	 /////////////////// USER REGISTRAR   http://localhost:8080/username/save ////////////////
	@PostMapping("/save")
	public ResponseEntity<Username> createUsername (@RequestBody Username username){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceUsername.save(username));
	}
	
	
	/////////////////// CONSULT USER   http://localhost:8080/username/consult ////////////////
	@GetMapping("/consult/{id}")
	public ResponseEntity<Optional<Username>> consultUsernameId (@PathVariable(value = "id") Long id){
		
		Optional<Username> user = serviceUsername.findById(id);
		
		if (user.isPresent()) {
			return ResponseEntity.ok(user);
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	
	/////////////////// UPDATE USER   http://localhost:8080/username/update ////////////////
	@PutMapping("/update/{id}")
	public ResponseEntity<Username> updateUser (@RequestBody Username newUser, @PathVariable(value = "id") Long id){
		
		Optional<Username> user = serviceUsername.findById(id);
		if (user.isPresent()) {
			
			user.get().setNickname(newUser.getNickname());
			user.get().setPassword(newUser.getPassword());
			user.get().setCellphoneNumber(newUser.getCellphoneNumber());
			user.get().setName(newUser.getName());
			
			return ResponseEntity.status(HttpStatus.CREATED).body(serviceUsername.save(user.get()));
			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	/////////////////// DELETE USER   http://localhost:8080/username/delete ////////////////
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Username> deleteUser(@PathVariable(value = "id")  Long id){
		
		
		if(serviceUsername.findById(id).isPresent()) {
			
			serviceUsername.deleteById(id);
			return ResponseEntity.ok().build();
			
		} else {
			
			return ResponseEntity.notFound().build();
		}		
	}
	
	/////////////////// CONSULT ALL USER   http://localhost:8080/username/consultall ///////////////	
	@GetMapping("/consultall")
	public  List<Username> consultAllUsers(){
		
		
		List<Username> users = StreamSupport
				.stream(serviceUsername.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return users;
	}
	
	 
}
