package collectNChill.collectnchill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import collectNChill.collectnchill.entity.Post;
import collectNChill.collectnchill.service.PostService;



@RestController
@RequestMapping("/users/{userId}/posts")
public class PostController {

	@Autowired
	PostService service;

	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getAllPosts() {
		return new ResponseEntity<Object>(service.getAllPosts(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/{postId}", method=RequestMethod.GET)
	public ResponseEntity<Object> getPost(@PathVariable long postId) {
		return new ResponseEntity<Object>(service.getPost(postId), HttpStatus.OK);
	}

	@RequestMapping(method=RequestMethod.POST) 
	public ResponseEntity<Object> createPost(@RequestBody Post post, @PathVariable Long userId) {
		try {
			return new ResponseEntity<Object>(service.createPost(post, userId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updatePost(@PathVariable Long postId, @RequestBody Post post) {
		try {
			return new ResponseEntity<Object>(service.updatePost(post, postId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/posts/{id}", method = RequestMethod.DELETE)
	public void deletePost(@PathVariable Long postId) {
		service.deletePost(postId);
	}
}
