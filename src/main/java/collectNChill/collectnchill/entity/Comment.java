package collectNChill.collectnchill.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	@Id
	@GeneratedValue
	private Long commentId;
	@NotNull
	private String comment;
	private User user;
	@JsonIgnore
	private Post post;
	private Date date;

	
	@ManyToOne
	@JoinColumn(name = "postId")
	@OnDelete(action = OnDeleteAction.CASCADE)
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getCommentId() {
		return commentId;
	}

	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@ManyToOne
	@JoinColumn(name = "userId")
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}
