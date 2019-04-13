package collectNChill.collectnchill.entity;


import java.util.Set;

//import javax.persistence.Entity;

public class Following {

	private Set<User> following;
	
	public Following(User user) {
		setFollowing(user.getFollowing());
	}

	public Set<User> getFollowing() {
		return following;
	}

	public void setFollowing(Set<User> following) {
		this.following = following;
	}
}


