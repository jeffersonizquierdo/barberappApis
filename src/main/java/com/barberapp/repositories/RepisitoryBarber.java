package com.barberapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barberapp.entities.Barber;


@Repository
public interface RepisitoryBarber extends JpaRepository<Barber, Integer >{



}
