package com.niit.portalbackend.daoImpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.portalbackend.Friend;
import com.niit.portalbackend.dao.FriendDao;

@Transactional
@Repository("friendDao")
public class FriendDaoImpl implements FriendDao {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addFriend(Friend friend) {
		sessionFactory.getCurrentSession().save(friend);
		return true;
	}

	@Override
	public boolean deleteFriend(Friend friend) {
		sessionFactory.getCurrentSession().delete(friend);
		return true;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public List<Friend> allFriends(String username) {
		try {
		Session s= sessionFactory.getCurrentSession();
		Query query = s.createQuery("from Friend where sentUser=? and status = '1' or receivedUser =? and status = '1' ");
		query.setParameter(0,username);
		query.setParameter(1,username);
		List<Friend> friends = query.getResultList();
		return friends;
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	

	@Override
	public boolean updateFriend(Friend friend) {
		sessionFactory.getCurrentSession().update(friend);
		return true;
	}

	@Override
	public Friend getFriend(int id) {
		return sessionFactory.getCurrentSession().get(Friend.class,id);
	}

}
