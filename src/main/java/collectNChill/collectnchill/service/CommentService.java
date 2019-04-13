package collectNChill.collectnchill.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.Comment;
import collectNChill.collectnchill.entity.Post;
import collectNChill.collectnchill.entity.User;
import collectNChill.collectnchill.repository.CommentRepository;
import collectNChill.collectnchill.repository.PostRepository;
import collectNChill.collectnchill.repository.UserRepository;


@Service
public class CommentService {
	
	@Autowired
	private CommentRepository repo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private PostRepository postRepo;
	
	
	
	public Comment createComment(Comment comment, Long postId, Long userId) throws Exception {
		User user = userRepo.findOne(userId);
		Post post = postRepo.findOne(postId);
		if (user == null || post == null) {
			throw new Exception("user or post does not exsist.");
		}
		comment.setDate(new Date());
		comment.setUser(user);
		comment.setPost(post);
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

		public PostRepository getPostRepo() {
			return postRepo;
		}

		public void setPostRepo(PostRepository postRepo) {
			this.postRepo = postRepo;
		}


}
