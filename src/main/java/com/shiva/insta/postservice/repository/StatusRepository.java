package com.shiva.insta.postservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shiva.insta.postservice.models.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {

}
