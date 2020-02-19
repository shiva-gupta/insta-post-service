package com.shiva.insta.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.insta.postservice.models.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}
