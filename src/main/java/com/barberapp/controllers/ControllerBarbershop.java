package com.barberapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.barberapp.servicies.barbershop.ServiceBarbershop;

@RestController
@RequestMapping("/barbershop")
public class ControllerBarbershop {
	
	@Autowired private ServiceBarbershop serviceBarbershop;
	
}
