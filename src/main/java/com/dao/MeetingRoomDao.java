package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.MeetingRoom;


public interface MeetingRoomDao  extends CrudRepository<MeetingRoom, Long>  {
	

}
