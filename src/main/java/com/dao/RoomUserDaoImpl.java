package com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.model.RoomUser;


@Transactional
@Repository
public class RoomUserDaoImpl implements RoomUserDao {
	
	@PersistenceContext	
	private EntityManager entityManager;	

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void delete(Long arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(RoomUser arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Iterable<? extends RoomUser> arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean exists(Long arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterable<RoomUser> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<RoomUser> findAll(Iterable<Long> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomUser findOne(Long arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <S extends RoomUser> S save(S arg0) {
		// TODO Auto-generated method stub
		entityManager.persist(arg0);
		return null;
	}

	@Override
	public <S extends RoomUser> Iterable<S> save(Iterable<S> arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoomUser get(String emailId,String password) {
		String hql = "FROM RoomUser WHERE emailId = ? and password = ?";
		try{
		List<RoomUser>users = entityManager.createQuery(hql).setParameter(1, emailId)
		              .setParameter(2, password).getResultList();
		return users.get(0);
		
		}catch(Exception e){
			
			return null;
		}
		
		
	}

}
