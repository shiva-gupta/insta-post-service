package com.shiva.insta.postservice.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.shiva.insta.postservice.exceptions.ResourceNotFoundException;
import com.shiva.insta.postservice.models.Post;
import com.shiva.insta.postservice.models.Status;
import com.shiva.insta.postservice.repository.PostRepository;

@Service
@PropertySource("classpath:data.properties")
public class PostServiceImpl implements PostService {
	
	@Autowired private PostRepository postRepository;
	
	@Value("${status.public.value}") private Integer publicStatusValue;

	@Override
	public Post save(Post post) {
		Status status = new Status(publicStatusValue);
		post.setStatus(status);
		
		return postRepository.save(post);
	}

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post findById(Long id) {
		Optional<Post> post = postRepository.findById(id);
		
		post.orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));
		
		return post.get();
	}

	@Override
	public void deleteAll() {
		postRepository.deleteAll();
	}

	@Override
	public void deleteById(Long id) {
		try{
			postRepository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Post with id " + id + " not found");
		}
	}

}
