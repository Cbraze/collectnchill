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
@RequestMapping("/main/post")
public class CommentController {

	@Autowired
	CommentService commentService;

	@RequestMapping("/{id}/comments")
	public Iterable<Comment> getComments() {
		return commentService.getComments();
	}

	@RequestMapping(value = "/{id}/comment", method = RequestMethod.POST)
	public Comment createComment(@RequestBody Comment comment) {
		return commentService.createComment(comment);
	}

	@RequestMapping(value = "/{id}/comment/{id}", method = RequestMethod.PUT)
	public Comment updateComment(@PathVariable Long commentId, @RequestBody Comment comment) {
		return commentService.updateComment(commentId, comment);
	}

	@RequestMapping(value = "/{id}/comment/{id}", method = RequestMethod.DELETE)
	public void deleteComment(@PathVariable Long commentId) {
		commentService.deleteComment(commentId);
	}
}
