package collectNChill.collectnchill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.Following;
import collectNChill.collectnchill.entity.User;
import collectNChill.collectnchill.repository.UserRepository;


@Service
public class UserService {

	@Autowired
	UserRepository repo;
	
	public User getUser(Long id) {
		return repo.findOne(id);
	}
	
	public Iterable<User> getUsers() {
		return repo.findAll();
	}
	
	public void deleteUser(Long id) {
		repo.delete(id);
	}
	
	public User updateUser(Long id, User user) {
		User foundUser = repo.findOne(id);
		if (foundUser != null) {
			foundUser.setUsername(user.getUsername());
			repo.save(foundUser);
		}
		return foundUser;
	}
	
	public Following follow(Long userId, Long followId) throws Exception {
		User user = repo.findOne(userId);
		User follow = repo.findOne(followId);
		if (user == null || follow == null) {
			throw new Exception("User does not exsist.");
		}
		user.getFollowing().add(follow);
		repo.save(user);
		return new Following(user);
	}
	
	public Following getFollowedUsers(Long userId) throws Exception {
		User user = repo.findOne(userId);
		if (user == null) {
			throw new Exception("User does not exist.");
		}
		return new Following(user);
	}
	
	public User updateProfilePicture(Long userId, String url) throws Exception {
		User user = repo.findOne(userId);
		if (user == null) {
			throw new Exception("User does not exsist.");
		}
		user.setProfilePictureUrl(url);
		return repo.save(user);
	}

}
