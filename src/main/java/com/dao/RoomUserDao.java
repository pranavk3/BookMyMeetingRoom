package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.RoomUser;



public interface RoomUserDao extends CrudRepository<RoomUser, Long>  {



RoomUser get(String emailId, String password);
	
	

}
