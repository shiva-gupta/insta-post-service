package com.shiva.insta.postservice.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="posts")
public class Post {

	/*
	 * Fields
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="post_id")
	private Long id;
	
	@Column(name="user_id", nullable=false, updatable=false)
	private Long userId;
	
	@Column(name="caption", updatable=true, nullable=true)
	@Type(type="text")
	private String caption;
	
	@Column(name="location", updatable=true, nullable=true)
	@Type(type="text")
	private String location;
	
	@Column(name="created_on", nullable=false, updatable=false)
	@CreationTimestamp
	private Calendar createdOn;
	
	@Column(name="modified_on", nullable=false, updatable=true)
	@LastModifiedDate
	private Calendar modifiedOn;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="status_id")
	private Status status;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="post", cascade=CascadeType.ALL)
	private List<Comment> comments;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="post", cascade=CascadeType.ALL)
	private List<Like> likes;

	
	/*
	 * Constructors
	 */
	public Post() {
		super();
	}

	public Post(Long userId) {
		super();
		this.userId = userId;
	}

	public Post(Long userId, String caption, String location) {
		super();
		this.userId = userId;
		this.caption = caption;
		this.location = location;
	}

	public Post(Long id, Long userId, String caption, String location,
			Calendar createdOn) {
		super();
		this.id = id;
		this.userId = userId;
		this.caption = caption;
		this.location = location;
		this.createdOn = createdOn;
	}

	public Post(Long id, Long userId, String caption, String location,
			Calendar createdOn, Calendar modifiedOn) {
		super();
		this.id = id;
		this.userId = userId;
		this.caption = caption;
		this.location = location;
		this.createdOn = createdOn;
		this.modifiedOn = modifiedOn;
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Calendar getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Calendar createdOn) {
		this.createdOn = createdOn;
	}

	public Calendar getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Calendar modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
	

	/*
	 * overridden methods
	 */
	@Override
	public String toString() {
		return "Post [id=" + id + ", userId=" + userId + ", caption=" + caption
				+ ", location=" + location + ", createdOn=" + createdOn
				+ ", modifiedOn=" + modifiedOn + ", status=" + status + "]";
	}
	
	
	/*
	 * Helper methods
	 */
	public void addComment(Comment comment) {
		if(comments==null) {
			comments = new ArrayList<Comment>();
		}
		comments.add(comment);
		comment.setPost(this);
	}
	
	public void addLike(Like like) {
		if(likes==null) {
			likes = new ArrayList<Like>();
		}
		likes.add(like);
		like.setPost(this);
	}
	
	@PrePersist
	@PreUpdate
	public void preUpdate() {
		this.modifiedOn = Calendar.getInstance();
	}
	
}
