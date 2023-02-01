package com.kalyan.demo.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@Entity
@Table(name = "post")
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
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

	public List<User> getUsersUpvoted() {
		return usersUpvoted;
	}

	public void setUsersUpvoted(List<User> usersUpvoted) {
		this.usersUpvoted = usersUpvoted;
	}

	public List<User> getUsersDownvoted() {
		return usersDownvoted;
	}

	public void setUsersDownvoted(List<User> usersDownvoted) {
		this.usersDownvoted = usersDownvoted;
	}

	@JsonBackReference(value = "user-posts")
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@Override
	public String toString() {
		return "Post [id=" + id + ", title=" + title + ", content=" + content + ", date_created=" + date_created
				+ ", date_edited=" + date_edited + ", user=" + user + ", comments=" + comments + "]";
	}

	@JsonManagedReference(value = "post-comments")
	@OneToMany(mappedBy = "post", fetch = FetchType.EAGER)
	private List<Comment> comments;

	@ManyToMany()
	@JoinTable(name = "upvoted_posts", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> usersUpvoted;

	@ManyToMany()
	@JoinTable(name = "downvoted_posts", joinColumns = @JoinColumn(name = "post_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> usersDownvoted;
}