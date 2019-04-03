package collectNChill.collectnchill.repository;

import org.springframework.data.repository.CrudRepository;

import collectNChill.collectnchill.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Long> { 
	
}