package com.barberapp.service.username;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barberapp.entities.Username;
import com.barberapp.repositories.RepositoryUsername;

@Service
public class ServiceUsernameImpl implements ServiceUsername{
	
	@Autowired(required = true) private RepositoryUsername repositoryUsername;

	@Override
	@Transactional(readOnly = true)
	public List<Username> findAll() {
		
		return repositoryUsername.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<Username> findAll(Pageable pageable) {
		
		return repositoryUsername.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<Username> findById(Long id) {
		
		return repositoryUsername.findById(id);
	}

	@Override
	public Username save(Username username) {
		
		return repositoryUsername.save(username);
	}

	@Override
	public void deleteById(Long id) {
		repositoryUsername.deleteById(id);
		
	}
	
	

}
