package com.shiva.insta.postservice.services;

import java.util.List;

import com.shiva.insta.postservice.models.Post;

public interface PostService {

	public Post save(Post post);
	
	public List<Post> findAll();
	public Post findById(Long id);
	
	public void deleteAll();
	public void deleteById(Long id);
	
}
