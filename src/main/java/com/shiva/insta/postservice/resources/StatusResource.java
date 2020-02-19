package com.shiva.insta.postservice.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.shiva.insta.postservice.models.Response;
import com.shiva.insta.postservice.services.StatusService;

@RestController
public class StatusResource {
	
	@Autowired private StatusService statusService;

	@GetMapping("/status")
	public ResponseEntity<?> findAll() {
		return ResponseEntity
					.ok(new Response(
							HttpStatus.OK.toString(), 
							true, 
							"Status List", 
							statusService.findAll()
						)
					);
		
	}
	
	@GetMapping("/status/{id}")
	public ResponseEntity<?> findById(@PathVariable("id") Integer id) {
		return ResponseEntity
					.ok(new Response(
							HttpStatus.OK.toString(), 
							true, 
							"Status List", 
							statusService.findById(id)
						)
					);
		
	}
	
}
