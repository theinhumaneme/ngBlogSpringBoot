package com.kalyan.demo.entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment{
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "content")
	private String content;
	
	@Column(name = "date_created")
	private Date date_created;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getdate_created() {
		return date_created;
	}

	public void setdate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Date getdate_edited() {
		return date_edited;
	}

	public void setdate_edited(Date date_edited) {
		this.date_edited = date_edited;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	// public List<User> getUsersUpvoted() {
	// 	return usersUpvoted;
	// }

	// public void setUsersUpvoted(List<User> usersUpvoted) {
	// 	this.usersUpvoted = usersUpvoted;
	// }

	// public List<User> getUsersDownvoted() {
	// 	return usersDownvoted;
	// }

	// public void setUsersDownvoted(List<User> usersDownvoted) {
	// 	this.usersDownvoted = usersDownvoted;
	// }

	@Column(name = "date_edited")
	private Date date_edited;
	
	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name="user_id")
	private User user;
	
    // @JsonBackReference
	@ManyToOne()
	@JoinColumn(name="post_id")
	private Post post;
	
	// @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	// @JoinTable(name="upvoted_comments",
	// 			joinColumns=@JoinColumn(name="comment_id"),
	// 			inverseJoinColumns=@JoinColumn(name="user_id"))
	// private List<User> usersUpvoted;
	
	// @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	// @JoinTable(name="downvoted_comments",
	// 			joinColumns=@JoinColumn(name="comment_id"),
	// 			inverseJoinColumns=@JoinColumn(name="user_id"))
	// private List<User> usersDownvoted;
	
}
