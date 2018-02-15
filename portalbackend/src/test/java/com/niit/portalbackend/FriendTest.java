package com.niit.portalbackend;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.portalbackend.dao.FriendDao;
import com.niit.portalbackend.dao.PortalUserDao;



public class FriendTest {
	
	AnnotationConfigApplicationContext context;
	PortalUserDao portalUserDao;
	portal_user user;
	FriendDao friendDao;
	Friend friend;
	
	@Before
	public void init()
	{
		context =  new AnnotationConfigApplicationContext();
		context.scan("com.niit");
		context.refresh();
		friendDao = (FriendDao)context.getBean("friendDao");
		friend = new Friend();
		portalUserDao = (PortalUserDao) context.getBean("portalUserDao");
	}
	
//	@Test
//	public void addFriend()
//	{
//		
//		friend.setSentUser("hansh");
//		friend.setReceivedUser("moulika");
//		friend.setStatus(0);
//		
//		Assert.assertEquals("Friend request sent", true, friendDao.addFriend(friend));
//		
//	}
	
//	@Test
//	public void updateFriend()
//	{
//		friend = friendDao.getFriend(142);
//		friend.setStatus(1);
//		
//		Assert.assertEquals("Friend updated", true, friendDao.updateFriend(friend));
//	}
//	
//
//	@Test
//	public void getFriends()
//	{
//		List<String> friends = friendDao.allFriends("hansh");
//		for(int i=0;i<friends.size();i++)
//		{
//			String f = friends.get(i);
//			System.out.println(f);
//		}
//	}
	
//	@Test
//	public void getSuggestedFriends()
//	{
//		List<String> friends = friendDao.suggestedFriends("chandu");
//		for(int i=0;i<friends.size();i++)
//			{
//				String f = friends.get(i);
//				System.out.println(f);
//			}
//		
//	}
	
	@Test
	public void getFriendRequests()
	{
		List<String> friends = friendDao.getFriendRequests("chandu");
		for(int i=0;i<friends.size();i++)
			{
				String f = friends.get(i);
				System.out.println(f);
			}
	}
}
