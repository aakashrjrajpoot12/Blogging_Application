package com.codeElevate.blogServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codeElevate.blogServer.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment,Long>{

	List<Comment> findByPostId(Long PostId);
	//Method will return list of comments and Query for this will be findByPostID
	
	
}
