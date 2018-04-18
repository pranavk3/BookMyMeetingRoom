package com.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="MeetingRoom")
public class MeetingRoom {
	
	@Id
	@GeneratedValue
	@Column
	private Long roomId;
	
	private String roomName;
	
	private String roomAddress;
	
	private String roomDescr;
	
	private String imageUrl;
	
	@Transient
	@JsonIgnore
	private MultipartFile file;

	public Long getRoomId() {
		return roomId;
	}

	public void setRoomId(Long roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public String getRoomAddress() {
		return roomAddress;
	}

	public void setRoomAddress(String roomAddress) {
		this.roomAddress = roomAddress;
	}

	public String getRoomDescr() {
		return roomDescr;
	}

	public void setRoomDescr(String roomDescr) {
		this.roomDescr = roomDescr;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public MeetingRoom(Long roomId, String roomName, String roomAddress, String roomDescr, String imageUrl,
			MultipartFile file) {
		super();
		this.roomId = roomId;
		this.roomName = roomName;
		this.roomAddress = roomAddress;
		this.roomDescr = roomDescr;
		this.imageUrl = imageUrl;
		this.file = file;
	}

	public MeetingRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
