package collectNChill.collectnchill.repository;

import org.springframework.data.repository.CrudRepository;

import collectNChill.collectnchill.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
	
	public User findByUsername(String username);

}
