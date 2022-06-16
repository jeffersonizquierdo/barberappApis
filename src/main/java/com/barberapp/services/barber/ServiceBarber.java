package com.barberapp.services.barber;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.barberapp.entities.Barber;



public interface ServiceBarber {
	
	public Iterable<Barber> findAll();
	
	public Page<Barber>findAll(Pageable pageable);
	
	public Optional<Barber>findById(Integer id);
	
	public Barber save(Barber barberVo);
	
	public void deletById(Integer id );

}
