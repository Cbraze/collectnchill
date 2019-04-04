package collectNChill.collectnchill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.Post;
import collectNChill.collectnchill.entity.User;
import collectNChill.collectnchill.repository.PostRepository;
import collectNChill.collectnchill.repository.UserRepository;


@Service
public class PostService {
	
	@Autowired
	PostRepository repo;
	
	@Autowired
	UserRepository userRepo;
	
	public Post createPost(Post post, Long userId) {
		User user = userRepo.findOne(userId);
		post.setUser(user);
		return repo.save(post);
	}

	public Post getPost(Long postId) {
		return repo.findOne(postId);
	}

	public Iterable<Post> getPosts() {
		return repo.findAll();
	}

	public void deletePost(Long postId) {
		repo.delete(postId);
	}


		public Post updatePost(Long postId, Post post) {
			Post foundPost= repo.findOne(postId);
			if (foundPost != null) {
				foundPost.setPost(post.getPost()); 	
				repo.save(foundPost);
			}
			return foundPost;
		}


}
