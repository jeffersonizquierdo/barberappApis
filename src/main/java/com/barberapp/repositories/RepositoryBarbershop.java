package com.barberapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository; 
import org.springframework.stereotype.Repository;

import com.barberapp.entities.Barbershop;

@Repository
public interface RepositoryBarbershop extends JpaRepository<Barbershop, Long>{

}
