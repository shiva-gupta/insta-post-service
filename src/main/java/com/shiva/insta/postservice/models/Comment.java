package com.shiva.insta.postservice.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="comments")
public class Comment {

	/*
	 * Fields
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="comment_id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = {
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinColumn(name="post_id")
	private Post post;
	
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="comment", updatable=true, nullable=false)
	@Type(type="text")
	private String comment;

	
	/*
	 * Constructors
	 */
	public Comment() {
		super();
	}

	public Comment(String comment) {
		super();
		this.comment = comment;
	}
	
	public Comment(Post post, Long userId, String comment) {
		super();
		this.post = post;
		this.userId = userId;
		this.comment = comment;
	}

	public Comment(Long id, Post post, Long userId, String comment) {
		super();
		this.id = id;
		this.post = post;
		this.userId = userId;
		this.comment = comment;
	}
	

	/*
	 * Getters/Setters
	 */
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	
	/*
	 * overridden methods
	 */
	@Override
	public String toString() {
		return "Comment [id=" + id + ", post=" + post + ", userId=" + userId
				+ ", comment=" + comment + "]";
	}
	
}
