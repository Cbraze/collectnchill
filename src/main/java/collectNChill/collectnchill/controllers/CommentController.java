package collectNChill.collectnchill.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import collectNChill.collectnchill.entity.Comment;
import collectNChill.collectnchill.service.CommentService;

@RestController
@RequestMapping("/users/{userId}/posts/{postId}")
public class CommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/comments")
	public Iterable<Comment> getComments() {
		return commentService.getComments();
	}

	@RequestMapping(value = "/comments", method = RequestMethod.POST)
	public Comment createComment(@RequestBody Comment comment, @PathVariable Long userId) {
		return commentService.createComment(comment, userId);
	}

	@RequestMapping(value = "/comments/{commentId}", method = RequestMethod.PUT)
	public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
		return commentService.updateComment(commentId, comment);
	}

	@RequestMapping(value = "/comments/{commentId}", method = RequestMethod.DELETE)
	public void deleteComment(@PathVariable Long commentId) {
		commentService.deleteComment(commentId);
	}
}
