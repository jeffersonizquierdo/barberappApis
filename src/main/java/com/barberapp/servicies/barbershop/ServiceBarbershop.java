package com.barberapp.servicies.barbershop;

import java.util.List;   
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.barberapp.entities.Barbershop;


public interface ServiceBarbershop {

	public List<Barbershop> findAll();
	
	public Page<Barbershop> findAll(Pageable pageable);
	
	public Optional<Barbershop> findById(Long id);
	
	public Barbershop save (Barbershop barbershop);
	
	public void deleteById (Long id);
}
