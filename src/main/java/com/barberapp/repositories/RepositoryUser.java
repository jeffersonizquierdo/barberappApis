package com.barberapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.barberapp.entities.User;

@Repository
public interface RepositoryUser extends JpaRepository<User, Long>{

}
