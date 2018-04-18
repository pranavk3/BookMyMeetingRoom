package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="RoomUser")
public class RoomUser {
	
	
	@Id
	@GeneratedValue
	@Column
	private Long RNo;
	
	private String firstName;
	
	private String lastName;
	
	private String emailId;
	
	private String password;

	public Long getRNo() {
		return RNo;
	}

	public void setRNo(Long rNo) {
		RNo = rNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RoomUser(Long rNo, String firstName, String lastName, String emailId, String password) {
		super();
		RNo = rNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
	}

	public RoomUser() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	

}
