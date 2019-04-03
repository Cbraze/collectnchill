package collectNChill.collectnchill.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import collectNChill.collectnchill.entity.Post;


import collectNChill.collectnchill.repository.PostRepository;


@Service
public class PostService {
	
	@Autowired
	PostRepository repo;
	
	public Post createPost(Post post) {
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
