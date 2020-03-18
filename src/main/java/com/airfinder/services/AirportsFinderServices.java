package com.airfinder.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.airfinder.cache.AirportsFinderCache;
import com.airfinder.http.HttpConnectionService;
@Service
public class AirportsFinderServices {
	@Autowired
	private AirportsFinderCache cache;
	@Autowired
	private HttpConnectionService service;
	
	public String getAirposts(String name) {
		if(cache.isValid(name)) {
			return cache.getJsons(name);
		}
		String json = service.getAirports(name);
		cache.save(name,json);
		return json;
	}

}
