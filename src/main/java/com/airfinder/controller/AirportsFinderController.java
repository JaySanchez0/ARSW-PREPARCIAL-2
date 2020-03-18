package com.airfinder.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.airfinder.services.AirportsFinderServices;

@RestController
@RequestMapping(value="/airports")
public class AirportsFinderController {
	@Autowired
	private AirportsFinderServices services;
	/**
	 * 
	 * @param name Nombre del aeropuerto
	 * @return Los aeropuertos que tienen este nombre
	 */
	@RequestMapping(value="/{name}")
	public ResponseEntity<?> getAirport(@PathVariable String name){
		return new ResponseEntity<>(services.getAirposts(name),HttpStatus.ACCEPTED);
	}
	
}