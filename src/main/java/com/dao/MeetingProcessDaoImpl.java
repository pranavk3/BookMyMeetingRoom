package com.dao;

import java.sql.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.model.Meeting;
import com.model.RoomUser;

@Transactional
@Repository
public class MeetingProcessDaoImpl implements MeetingProcessDao {

	

	@PersistenceContext	
	private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;		
	}
	@Override
	public List<Meeting> get(String emailId) {
		String hql = "FROM Meeting WHERE createdBy = ?";
		try{
		List<Meeting>meetings= entityManager.createQuery(hql).setParameter(1, emailId)
		             .getResultList();
		return meetings;
		
		}catch(Exception e){
			
			return null;
		}
	}
	@Override
	public boolean update(Meeting meeting) {
		try{
			System.out.println("*********");
	//Session session=sessionFactory.openSession();
			Session session=	sessionFactory.getCurrentSession();
		session.update(meeting);
		System.out.println("&&&&&&&&&&");
		//session.close();
		return true;
		}
		catch(Exception exc)
		{
			exc.printStackTrace();
		return false;
		}
	}
	@Override
	public List<Meeting> getMeetingToSendMail(Date fromDate, String time) {
		try
		{
			System.out.println("inside getMeetingToSendMail ");
	
		String hql = "FROM Meeting WHERE dateFrom=? and timeFrom=?";
		List<Meeting>meetings=entityManager.createQuery(hql).setParameter(1,fromDate).setParameter(2, time).getResultList();
		
		System.out.println("&&&&&&&&&&&&&&&&&&"+meetings);
		if(!meetings.isEmpty())
		{
		return meetings;
		}
		else
		{
			return null;
		}
		}
	
	catch(Exception e)
	{
		return null;
	}
		
	}

}
