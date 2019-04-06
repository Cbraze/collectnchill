package collectNChill.collectnchill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.Comment;
import collectNChill.collectnchill.entity.User;
import collectNChill.collectnchill.repository.CommentRepository;
import collectNChill.collectnchill.repository.PostRepository;
import collectNChill.collectnchill.repository.UserRepository;


@Service
public class CommentService {
	
	@Autowired
	CommentRepository repo;
	@Autowired
	UserRepository userRepo;
	@Autowired
	PostRepository postRepo;
	
	public Comment createComment(Comment comment, Long userId) {
		User user = userRepo.findOne(userId);
		comment.setUser(user);
		return repo.save(comment);
	}

	public Comment getComment(Long commentId) {
		return repo.findOne(commentId);
	}

	public Iterable<Comment> getComments() {
		return repo.findAll();
	}

	public void deleteComment(Long commentId) {
		repo.delete(commentId);
	}


		public Comment updateComment(Long commentId, Comment comment) {
			Comment foundComment= repo.findOne(commentId);
			if (foundComment != null) {
				foundComment.setComment(comment.getComment()); 	
				repo.save(foundComment);
			}
			return foundComment;
		}


}
