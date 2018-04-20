package com.model;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;



@Entity
@Table(name="Meeting")
public class Meeting {

	
	@Id
	@GeneratedValue
	@Column
	private long meetingId;
	
	private String meetingRoomName;
	
	private Date dateFrom;
	
	private Date dateTo;
	
	private String timeFrom;
	
	private String timeTo;
	
	private String createdBy;
	
	private Timestamp createdAt;
	
	private String updatedBy;
	
	private Timestamp updatedAt;
	
	
	
	@Transient
	private String tFrom;
	
	@Transient
	private String tTo;
	

	public long getMeetingId() {
		return meetingId;
	}

	public void setMeetingId(long meetingId) {
		this.meetingId = meetingId;
	}

	public String getMeetingRoomName() {
		return meetingRoomName;
	}

	public void setMeetingRoomName(String meetingRoomName) {
		this.meetingRoomName = meetingRoomName;
	}

	public Date getDateFrom() {
		return dateFrom;
	}

	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}

	public Date getDateTo() {
		return dateTo;
	}

	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeTo() {
		return timeTo;
	}

	public void setTimeTo(String timeTo) {
		this.timeTo = timeTo;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		
		
		this.updatedAt = updatedAt;
	}
	
	

	public String gettFrom() {
		return tFrom;
	}

	public void settFrom(String tFrom) {
		this.tFrom = tFrom;
	}

	public String gettTo() {
		return tTo;
	}

	public void settTo(String tTo) {
		this.tTo = tTo;
	}

	public Meeting(long meetingId, String meetingRoomName, Date dateFrom, Date dateTo, String timeFrom,
			String timeTo, String createdBy, Timestamp createdAt, String updatedBy, Timestamp updatedAt) {
		super();
		this.meetingId = meetingId;
		this.meetingRoomName = meetingRoomName;
		this.dateFrom = dateFrom;
		this.dateTo = dateTo;
		this.timeFrom = timeFrom;
		this.timeTo = timeTo;
		this.createdBy = createdBy;
		this.createdAt = createdAt;
		this.updatedBy = updatedBy;
		this.updatedAt = updatedAt;
	}

	public Meeting() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
