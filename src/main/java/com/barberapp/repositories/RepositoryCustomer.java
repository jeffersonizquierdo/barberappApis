package com.barberapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.barberapp.entities.Customer;

@Repository
public interface RepositoryCustomer extends JpaRepository<Customer, Long>{

}
