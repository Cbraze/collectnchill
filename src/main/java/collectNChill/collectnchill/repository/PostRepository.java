package collectNChill.collectnchill.repository;

import org.springframework.data.repository.CrudRepository;

import collectNChill.collectnchill.entity.Post;

public interface PostRepository extends CrudRepository<Post, Long> { 
	
}