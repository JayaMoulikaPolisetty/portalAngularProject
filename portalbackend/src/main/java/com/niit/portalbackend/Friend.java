package com.niit.portalbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Friend {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	private int friendId;
	
	private String sentUser;
	
	private String receivedUser;
	
	private int status;

	
	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getSentUser() {
		return sentUser;
	}

	public void setSentUser(String sentUser) {
		this.sentUser = sentUser;
	}

	public String getReceivedUser() {
		return receivedUser;
	}

	public void setReceivedUser(String receivedUser) {
		this.receivedUser = receivedUser;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
}
