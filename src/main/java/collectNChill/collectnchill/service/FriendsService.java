package collectNChill.collectnchill.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import collectNChill.collectnchill.entity.Friends;

import collectNChill.collectnchill.entity.User;
import collectNChill.collectnchill.repository.FriendRepository;
import collectNChill.collectnchill.repository.UserRepository;

@Service
public class FriendsService {
	
	@Autowired
	UserRepository userRepo;
	@Autowired
	FriendRepository friendRepo;
	
	public Friends createFriends(Friends friends, Long userId) {
		User user = userRepo.findOne(userId);
		friends.setUser(user);
		return friendRepo.save(friends);
	}
	
	public Iterable<Friends> getFriends() {
		return friendRepo.findAll();
	}
}
