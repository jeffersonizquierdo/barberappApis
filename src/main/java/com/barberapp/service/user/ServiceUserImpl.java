package com.barberapp.service.user;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.barberapp.entities.User;
import com.barberapp.repositories.RepositoryUsername;

@Service
public class ServiceUserImpl implements ServiceUser{
	
	@Autowired(required = true) private RepositoryUsername repositoryUser;

	@Override
	@Transactional(readOnly = true)
	public List<User> findAll() {
		
		return repositoryUser.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<User> findAll(Pageable pageable) {
		
		return repositoryUser.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<User> findById(Long id) {
		
		return repositoryUser.findById(id);
	}

	@Override
	public User save(User username) {
		
		return repositoryUser.save(username);
	}

	@Override
	public void deleteById(Long id) {
		repositoryUser.deleteById(id);
		
	}
	
	

}
