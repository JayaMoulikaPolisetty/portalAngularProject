package com.niit.portalmiddleware.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.niit.portalbackend.Friend;
import com.niit.portalbackend.dao.FriendDao;

@RestController
public class FriendController {
	
	@Autowired
	FriendDao friendDao;
	
	@GetMapping("/friendrequests")
	public ResponseEntity<?> friendrequests(@RequestParam("username") String username)
	{
		try {
			List<String> friends = friendDao.getFriendRequests(username);
			System.out.println(friends);
			return new ResponseEntity<List<String>>(friends, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("null", HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/friends")
	public ResponseEntity<?> friends(@RequestParam("username") String username)
	{
		try {
			List<String> friends = friendDao.allFriends(username);
			System.out.println(friends);
			return new ResponseEntity<List<String>>(friends, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("null", HttpStatus.NOT_FOUND);
		}
	}
	@GetMapping("/suggested")
	public ResponseEntity<?> suggestedFrnds(@RequestParam("username") String username)
	{
		try {
			List<String> friends = friendDao.suggestedFriends(username);
			System.out.println(friends);
			return new ResponseEntity<List<String>>(friends, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("null", HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/sendRequest")
	public ResponseEntity<?> sendRequest(@RequestBody Friend friend)
	{
		try {
			friendDao.addFriend(friend);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Boolean>(false, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/acceptRequest")
	public ResponseEntity<?> acceptRequest(@RequestBody Friend frnd)
	{
		try {
			Friend friend = friendDao.getFriend(frnd);
			friend.setStatus(1);
			friendDao.updateFriend(friend);
			return new ResponseEntity<Friend>(friend, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@PostMapping("/rejectRequest")
	public ResponseEntity<?> rejectRequest(@RequestBody Friend frnd)
	{
		try {
			Friend friend = friendDao.getFriend(frnd);
			
			friendDao.deleteFriend(friend);
			return new ResponseEntity<Boolean>(true, HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<Boolean>(false,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
