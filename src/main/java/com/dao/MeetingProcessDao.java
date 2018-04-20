package com.dao;

import java.util.List;

import com.model.Meeting;

public interface MeetingProcessDao {
	
	List<Meeting>get(String emailId);
	
	boolean update(Meeting meeting);

}
