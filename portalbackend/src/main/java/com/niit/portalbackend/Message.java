package com.niit.portalbackend;

import java.io.Serializable;

public class Message implements Serializable{

	private static final long serialVersionUID = 1L;
	private String message;
	private String username;
	
	public Message() {
	    
	  }
	  
	  public Message(String username, String message) {
	    this.username = username;
	    this.message = message;
	  }
	  
	  
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	  
}
