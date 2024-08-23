package com.codeElevate.blogServer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codeElevate.blogServer.entity.Post;
@Repository
public interface PostRepository extends JpaRepository<Post,Long>{
	
	List<Post> findAllByNameContaining(String name);
	//this method will return list of post,Query for which will be findAllByNameContaining


}
