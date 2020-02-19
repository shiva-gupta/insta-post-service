package com.shiva.insta.postservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="status")
public class Status {

	/*
	 * Fields
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="status_id")
	private Integer id;
	
	@Column(name="status", unique=true, updatable=false, nullable=false, length=20)
	private String status;
	
	
	/*
	 * Constructors
	 */
	public Status() {
		super();
	}
	
	public Status(Integer id) {
		super();
		this.id = id;
	}

	public Status(Integer id, String status) {
		super();
		this.id = id;
		this.status = status;
	}

	
	/*
	 * Getters/Setters
	 */
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	/*
	 * overridden methods
	 */
	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + "]";
	}
	
}
