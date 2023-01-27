package com.kalyan.demo.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

	@Column(name = "date_created")
	private Date date_created;

	@Column(name = "date_edited")
	private Date date_edited;

	public Date getDate_created() {
		return date_created;
	}

	public void setDate_created(Date date_created) {
		this.date_created = date_created;
	}

	public Date getDate_edited() {
		return date_edited;
	}

	public void setDate_edited(Date date_edited) {
		this.date_edited = date_edited;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	// public Date getdate_created() {
	// return date_created;
	// }

	// public void setdate_created(Date date_created) {
	// this.date_created = date_created;
	// }

	// public Date getLastEdited() {
	// return lastEdited;
	// }

	// public void setLastEdited(Date lastEdited) {
	// this.lastEdited = lastEdited;
	// }

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Comment> getComments() {
	return comments;
	}

	public void setComments(List<Comment> comments) {
	this.comments = comments;
	}

	// public List<User> getUsersUpvoted() {
	// return usersUpvoted;
	// }

	// public void setUsersUpvoted(List<User> usersUpvoted) {
	// this.usersUpvoted = usersUpvoted;
	// }

	// public List<User> getUsersDownvoted() {
	// return usersDownvoted;
	// }

	// public void setUsersDownvoted(List<User> usersDownvoted) {
	// this.usersDownvoted = usersDownvoted;
	// }

	@JsonBackReference
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@JsonManagedReference
	@OneToMany(mappedBy="post")
	private List<Comment> comments;

	// @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	// @JoinTable(name="upvoted_posts",
	// joinColumns=@JoinColumn(name="post_id"),
	// inverseJoinColumns=@JoinColumn(name="user_id"))
	// private List<User> usersUpvoted;

	// @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	// @JoinTable(name="downvoted_posts",
	// joinColumns=@JoinColumn(name="post_id"),
	// inverseJoinColumns=@JoinColumn(name="user_id"))
	// private List<User> usersDownvoted;
}