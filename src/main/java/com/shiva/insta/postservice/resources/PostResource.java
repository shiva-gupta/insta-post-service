package com.shiva.insta.postservice.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import com.shiva.insta.postservice.models.Post;
import com.shiva.insta.postservice.models.Response;
import com.shiva.insta.postservice.services.PostService;

@RestController
public class PostResource {

	@Autowired private PostService postService;
	
	@PostMapping("/posts")
	public ResponseEntity<?> save(@RequestBody Post post) throws URISyntaxException {
		postService.save(post);
		
		final String url = MvcUriComponentsBuilder.fromController(this.getClass())
			.path("/posts/{id}")
			.buildAndExpand(post.getId())
			.toUri().toString();
		
		return ResponseEntity
					.created(new URI(url))
					.body(new Response(
							HttpStatus.CREATED.toString(), 
							true, 
							"Post uploaded", 
							post)
					);
	}
	
	@GetMapping("/posts")
	public ResponseEntity<?> findAll() {
		List<Post> posts = postService.findAll();
		
		return ResponseEntity
					.ok(new Response(
							HttpStatus.OK.toString(),
							true,
							"Post list",
							posts
						)
					);
	}
	
	@GetMapping("/posts/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Long id) {
		Post post = postService.findById(id);
		
		return ResponseEntity
					.ok(new Response(
							HttpStatus.OK.toString(),
							true,
							"Post detail",
							post
						)
					);
	}
	
	@DeleteMapping("/posts")
	public ResponseEntity<?> deleteAll() {
		postService.deleteAll();
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@DeleteMapping("/posts/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id) {
		postService.deleteById(id);
		
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
}
