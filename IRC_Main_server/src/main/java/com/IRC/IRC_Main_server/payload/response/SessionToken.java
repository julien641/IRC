package com.IRC.IRC_Main_server.payload.response;

public class SessionToken{
	 private String token;
	 private String type = "Bearer";
	 private int expMS;
	
	
	public SessionToken(String token, String type, int expMS) {
		super();
		this.token = token;
		this.type = type;
		this.expMS = expMS;
	}


	public SessionToken() {
		
		
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public int getExpMS() {
		return expMS;
	}


	public void setExpMS(int expMS) {
		this.expMS = expMS;
	}
	
	
}