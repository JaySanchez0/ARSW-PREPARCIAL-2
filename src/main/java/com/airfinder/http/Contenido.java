package com.airfinder.http;

import java.util.List;

public class Contenido {
	
	
	private long time;
	
	private String json;
	/**
	 * 
	 * @param time - Tiempo de valides
	 * @param json - Json a almacenar
	 */
	public Contenido(long time,String json) {
		this.json=json;
		this.time=time;
	}
	/**
	 * 
	 * @return tiempo de validez
	 */
	public long getTime() {
		return time;
	}
	/**
	 * 
	 * @param time nuevo tiempo de validez
	 */
	public void setTime(long time) {
		this.time = time;
	}
	/**
	 * 
	 * @return objeto json almacenado
	 */
	public String getJson() {
		return json;
	}
	/**
	 * 
	 * @param json objeto json a almacenar
	 */
	public void setJson(String json) {
		this.json = json;
	}
	
	
}
