package collectNChill.collectnchill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import collectNChill.collectnchill.entity.Comment;
import collectNChill.collectnchill.service.CommentService;

@RestController
@RequestMapping("/users/{userId}/posts/{postId}/comments")
public class CommentController {

	@Autowired
	CommentService service;

	@RequestMapping("/all")
	public Iterable<Comment> getComments() {
		return service.getComments();
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Object> createComment(@RequestBody Comment comment, @PathVariable Long userId, @PathVariable Long postId) {
		try {
			return new ResponseEntity<Object>(service.createComment(comment, userId, postId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@RequestMapping(value = "/{commentId}", method = RequestMethod.PUT)
	public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
		return service.updateComment(commentId, comment);
	}

	@RequestMapping(value = "/{commentId}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteComment(@PathVariable Long commentId) {
		service.deleteComment(commentId);
		return new ResponseEntity<Object>("Deleted comment with id: " + commentId, HttpStatus.OK);
	}
}
