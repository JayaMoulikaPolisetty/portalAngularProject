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

	
	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<String> allFriends(String username) {
		try {
		Session s= sessionFactory.getCurrentSession();
		//Query query = s.createQuery("from Friend where sentUser=? and status = '1' or receivedUser =? and status = '1' ");
		return s.createSQLQuery("select receivedUser from friend where sentUser=? and status=1 union select sentUser from friend where receivedUser=? and status=1")
		      .setParameter(0, username)
		      .setParameter(1, username)
		      .getResultList();
		}
		catch(Exception e)
		{
			return null;
		}
		
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<String> suggestedFriends(String username) {
		try {
			Session s = sessionFactory.getCurrentSession();
			return s.createSQLQuery("select username from portal_user where username!=? and (username not in (select receivedUser from friend where sentUser=? union select sentUser from friend where receivedUser=?))")
					.setParameter(0, username)
					.setParameter(1, username)
					.setParameter(2, username)
					.getResultList();
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

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<String> getFriendRequests(String username) {
		try
		{
			Session s = sessionFactory.getCurrentSession();
			return s.createSQLQuery("select sentUser from friend where receivedUser=? and status=0")
					.setParameter(0, username)
					.getResultList();
		}	catch(Exception e)
		{
			return null;
		}
	}

}
