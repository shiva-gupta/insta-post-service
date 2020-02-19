package com.shiva.insta.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.insta.postservice.models.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

}
