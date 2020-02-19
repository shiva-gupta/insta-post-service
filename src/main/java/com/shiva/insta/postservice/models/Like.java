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

@Entity
@Table(name="likes")
public class Like {

	/*
	 * Fields
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="like_id")
	private Long id;
	
	@ManyToOne(fetch=FetchType.EAGER, cascade = {
			CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH
	})
	@JoinColumn(name="post_id")
	private Post post;
	
	@Column(name="user_id")
	private Long userId;

	
	/*
	 * Constructors
	 */
	public Like() {
		super();
	}


	public Like(Post post, Long userId) {
		super();
		this.post = post;
		this.userId = userId;
	}


	/*
	 * Getters/Setters
	 */
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

	/*
	 * overridden methods
	 */
	@Override
	public String toString() {
		return "Like [post=" + post + ", userId=" + userId + "]";
	}

}
