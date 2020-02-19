package com.shiva.insta.postservice.services;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.shiva.insta.postservice.config.StorageProperties;
import com.shiva.insta.postservice.exceptions.ResourceNotFoundException;
import com.shiva.insta.postservice.exceptions.StorageException;
import com.shiva.insta.postservice.models.Post;
import com.shiva.insta.postservice.models.Status;
import com.shiva.insta.postservice.repository.PostRepository;

@Service
@PropertySource("classpath:data.properties")
public class PostServiceImpl implements PostService {

	@Autowired private PostRepository postRepository;

	@Value("${status.public.value}") private Integer publicStatusValue;

	private final Path postRootLocation;
	private final String postRootLocationAbsolutePath;
	@Autowired
	public PostServiceImpl(StorageProperties storageProperties) {
		this.postRootLocation = Paths.get(storageProperties.getPostLocation());
		this.postRootLocationAbsolutePath = new File(postRootLocation.toString())
		.getAbsolutePath();
	}

	@Override
	public void initDir() {
		try {
			Files.createDirectories(postRootLocation);
		} catch (IOException e) {
			throw new StorageException("Could not intialize post dir", e);
		}
	}

	@Override
	public Post save(Post post) {
		Status status = new Status(publicStatusValue);
		post.setStatus(status);

		String image = savePostImage(post.getImage(), post.getUserId());
		post.setImage(image);

		return postRepository.save(post);
	}

	@Override
	public List<Post> findAll() {
		List<Post> posts = postRepository.findAll();
		
		Iterator<Post> itr = posts.iterator();
		while(itr.hasNext()) {
			Post post = itr.next();
			post.setImage(base64Encode(post.getImage()));
		}
		
		return posts;
	}

	@Override
	public Post findById(Long id) {
		Optional<Post> post = postRepository.findById(id);

		post.orElseThrow(() -> new ResourceNotFoundException("Post with id " + id + " not found"));

		post.get().setImage(base64Encode(post.get().getImage()));
		
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

	@Override
	public String savePostImage(String image, Long userId) {
		try {
			byte[] imageByte = Base64.decodeBase64(image);

			String fileName = System.currentTimeMillis() + ".jpg";

			File directory = new File(postRootLocationAbsolutePath + "\\" + userId);
			if(!directory.exists()) {
				directory.mkdir();
			}

			String filePath = directory.getAbsolutePath() + "\\" +  fileName;

			new FileOutputStream(filePath).write(imageByte);

			return userId + "\\" + fileName;
		} catch(Exception e) {
			return null;
		}
	}

	@Override
	public String base64Encode(String filePath) {
		filePath = postRootLocationAbsolutePath + "\\" + filePath;
		System.out.println(filePath);
		Path path = Paths.get(filePath);
		try {
			return new String(Base64.encodeBase64(Files.readAllBytes(path)), "UTF-8");
		} catch (IOException e) {
			return null;
		}
	}
	
}
