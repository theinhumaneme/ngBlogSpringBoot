package com.kalyan.demo.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
@Entity
@Table(name = "comment")
public class Comment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	@Column(name = "date_edited")
	private Date date_edited;

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", date_created=" + date_created + ", date_edited="
				+ date_edited + ", user=" + user + ", post=" + post + "]";
	}

	@JsonBackReference(value = "user-comments")
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;

	@JsonBackReference(value = "post-comments")
	@ManyToOne()
	@JoinColumn(name = "post_id")
	private Post post;

	@ManyToMany()
	@JoinTable(name = "upvoted_comments", joinColumns = @JoinColumn(name = "comment_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> usersUpvoted;

	@ManyToMany()
	@JoinTable(name = "downvoted_comments", joinColumns = @JoinColumn(name = "comment_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<User> usersDownvoted;

}
