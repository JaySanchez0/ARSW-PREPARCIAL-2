package com.airfinder.http;

import org.springframework.stereotype.Service;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap; 

@Service
public class HttpConnectionService {
	/**
	 * 
	 * @param name nombre del aeropuerto
	 * @return objeto json con la info de los aeropuertos
	 */
	public String getAirports(String name) {
		try {
			HttpResponse<String> response = Unirest.get("https://cometari-airportsfinder-v1.p.rapidapi.com/api/airports/by-text?text="+name)
					.header("x-rapidapi-host", "cometari-airportsfinder-v1.p.rapidapi.com")
					.header("x-rapidapi-key", "44dcd8f5d7mshf550bed2a1a379dp1fc49djsnf9da109a1513")
					.asString();
			String data = response.getBody();
			return data;
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
