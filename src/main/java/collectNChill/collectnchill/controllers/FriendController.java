package collectNChill.collectnchill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import collectNChill.collectnchill.entity.Friends;
import collectNChill.collectnchill.service.FriendsService;


@RestController
@RequestMapping("/users/{id}")
public class FriendController {
	
	@Autowired
	FriendsService friendsService;
	
	@RequestMapping(value ="/friends", method=RequestMethod.POST) 
	public Friends createFriends(@RequestBody Friends friends, @PathVariable Long userId) {
		return friendsService.createFriends(friends, userId);
	}
	
	@RequestMapping("/myfriends")
	public Iterable<Friends> getFriends() {
		return friendsService.getFriends();
	}
}
