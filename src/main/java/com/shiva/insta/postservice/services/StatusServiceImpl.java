package com.shiva.insta.postservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shiva.insta.postservice.exceptions.ResourceNotFoundException;
import com.shiva.insta.postservice.models.Status;
import com.shiva.insta.postservice.repository.StatusRepository;

@Service
public class StatusServiceImpl implements StatusService {
	
	@Autowired private StatusRepository statusRepository;

	@Override
	public List<Status> findAll() {
		return statusRepository.findAll();
	}

	@Override
	public Status findById(Integer id) {
		Optional<Status> status = statusRepository.findById(id);
		status.orElseThrow(() -> new ResourceNotFoundException("Status with id " + id + " not found"));
		return status.get();
	}

}
