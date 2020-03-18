package com.airfinder.cache;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Component;

import com.airfinder.http.Contenido;
@Component
public class AirportsFinderCache {
	private ConcurrentHashMap<String,Contenido> con = new ConcurrentHashMap<>();
	/**
	 * 
	 * @param name -Nombre del aeropuerto a consultar
	 * @return si este aeropuerto esta o no en cache
	 */
	public boolean isValid(String name) {
		//System.out.println(con.get(name));
		if(con.get(name)!=null && (System.currentTimeMillis()-con.get(name).getTime())<=(1000*60*5)) return true;
		return false;
	}
	/**
	 * 
	 * @param name Nombre del aeropuerto
	 * @return Devuelve el json en memoria del aeropuerto
	 */
	public String getJsons(String name) {
		return con.get(name).getJson();
	}
	/**
	 * 
	 * @param name Nombre del aeropuerto
	 * @param json json correspondiente a el aeropuerto
	 */
	public void save(String name,String json) {
		con.put(name,new Contenido(System.currentTimeMillis(),json));
		System.out.println("Guardo en cache");
	}

}
