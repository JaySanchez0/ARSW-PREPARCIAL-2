package com.airfinder.http;

import java.util.List;

public class Contenido {
	
	
	private long time;
	
	private String json;
	
	public Contenido(long time,String json) {
		this.json=json;
		this.time=time;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}
	
	
}
