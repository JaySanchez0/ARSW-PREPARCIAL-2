package com.airfinder.cache;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.airfinder.http.Contenido;
@Component
public class AirportsFinderCache {
	private ConcurrentHashMap<String,Contenido> con = new ConcurrentHashMap<>();
	public boolean isValid(String name) {
		if(con.get(name)!=null && System.currentTimeMillis()-con.get(name).getTime()<=5000) return true;
		return false;
	}
	public String getJsons(String name) {
		return con.get(name).getJson();
	}
	public void save(String name,String json) {
		con.put(name,new Contenido(System.currentTimeMillis(),json));
	}

}
