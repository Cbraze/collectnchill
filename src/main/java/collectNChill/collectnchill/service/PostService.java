package collectNChill.collectnchill.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.Post;
import collectNChill.collectnchill.entity.User;
import collectNChill.collectnchill.repository.PostRepository;
import collectNChill.collectnchill.repository.UserRepository;

@Service
public class PostService {

	@Autowired
	private PostRepository repo;

	@Autowired
	private UserRepository userRepo;

	public Post createPost(Post post, Long userId) throws Exception {
		User user = userRepo.findOne(userId);
		if (user == null) {
			throw new Exception("User not found.");
		}
		post.setDate(new Date());
		post.setUser(user);
		return repo.save(post);
	}

	public Post getPost(Long id) {
		return repo.findOne(id);
	}

	public Iterable<Post> getAllPosts() {
		return repo.findAll();
	}

	public void deletePost(Long postId) {
		repo.delete(postId);
	}

	public Post updatePost(Post post, Long id) throws Exception {
		Post foundPost = repo.findOne(id);
		if (foundPost == null) {
			throw new Exception("Post not found.");
		}
		foundPost.setPost(post.getPost());
		return repo.save(foundPost);
	}

}
