package com.shiva.insta.postservice.services;

import java.util.List;

import com.shiva.insta.postservice.models.Status;

public interface StatusService {

	public List<Status> findAll();
	public Status findById(Integer id);
	
}
