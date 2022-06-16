package com.barberapp.service.username;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.barberapp.entities.Username;


public interface ServiceUsername {
	
	public Iterable<Username> findAll();
	
	public Page<Username> findAll(Pageable pageable);
	
	public Optional<Username> findById(Long id);
	
	public Username save (Username username);
	
	public void deleteById (Long id);

}
