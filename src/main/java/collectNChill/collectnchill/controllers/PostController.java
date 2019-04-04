package collectNChill.collectnchill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import collectNChill.collectnchill.entity.Post;
import collectNChill.collectnchill.service.PostService;



@RestController
@RequestMapping("/users/{userId}")
public class PostController {

	@Autowired
	PostService postService;

	@RequestMapping("/posts")
	public Iterable<Post> getPosts() {
		return postService.getPosts();
	}

	@RequestMapping(value ="/posts", method=RequestMethod.POST) 
	public Post createPost(@RequestBody Post post, @PathVariable Long userId) {
		return postService.createPost(post, userId);
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
	public Post updatePost(@PathVariable Long postId, @RequestBody Post post) {
		return postService.updatePost(postId, post);
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable Long postId) {
		postService.deletePost(postId);
	}
}
