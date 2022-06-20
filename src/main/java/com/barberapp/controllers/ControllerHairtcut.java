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

import com.barberapp.entities.Haircuts;
import com.barberapp.services.haircut.ServiceHaircut;

@RestController
@RequestMapping("haircuts")
public class ControllerHairtcut {

	@Autowired
	private ServiceHaircut serviceHaircut;
	
	//create a new Haircuts
	@PostMapping
	public ResponseEntity<?> create (@RequestBody Haircuts haircut) {
		
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceHaircut.save(haircut));
	}

	// Read an Haircuts
	@GetMapping("/update/{id}")
	public ResponseEntity<?> read (@PathVariable(value = "id") Long haircutsId){
		Optional<Haircuts> oHaircuts = serviceHaircut.findById(haircutsId);
		
		if(!oHaircuts.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(oHaircuts);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?>update(@RequestBody Haircuts haircutNew,@PathVariable (value = "id")Long haircutid ){
		Optional<Haircuts> haircuts=serviceHaircut.findById(haircutid);
		
		if(!haircuts.isPresent()) {
			return ResponseEntity.notFound().build();
			
			}
		haircuts.get().setNameHaircut(haircutNew.getNameHaircut());
		haircuts.get().setHairImage(haircutNew.getHairImage());
		haircuts.get().setDescrition(haircutNew.getDescrition());
		return ResponseEntity.status(HttpStatus.CREATED).body(serviceHaircut.save(haircuts.get()));
		}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Haircuts> deleteUser(@PathVariable(value = "id")  Long id){
		
		
		if(!serviceHaircut.findById(id).isPresent()) {
			
			return ResponseEntity.notFound().build();
			
		} else {
			serviceHaircut.deleteById(id);
			return ResponseEntity.ok().build();
		}		
	}

	@GetMapping("/consul")
	public  List<Haircuts> consultAllUsers(){
		
		
		List<Haircuts> haircuts = StreamSupport
				.stream(serviceHaircut.findAll().spliterator(), false)
				.collect(Collectors.toList());
		
		return  haircuts;
	}
}
