package com.dao;

import org.springframework.data.repository.CrudRepository;

import com.model.Meeting;


public interface MeetingDao extends CrudRepository<Meeting, Long>  {

}
