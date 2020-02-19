package com.shiva.insta.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.insta.postservice.models.Like;

public interface LikeRepository extends JpaRepository<Like, Long> {

}
