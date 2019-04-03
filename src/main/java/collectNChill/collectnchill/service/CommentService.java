package collectNChill.collectnchill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.Comment;
import collectNChill.collectnchill.repository.CommentRepository;


@Service
public class CommentService {
	
	@Autowired
	CommentRepository repo;
	
	public Comment createComment(Comment comment) {
		return repo.save(comment);
	}

	public Comment getPost(Long commentId) {
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
