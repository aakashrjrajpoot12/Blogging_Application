package com.codeElevate.blogServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codeElevate.blogServer.entity.Post;
import com.codeElevate.blogServer.service.PostService;

import jakarta.persistence.EntityNotFoundException;

@RestController
@RequestMapping("/api/posts")
@CrossOrigin(origins="*")
public class PostController {
	
	@Autowired
	private PostService postService;
	
	//endpoint
	@PostMapping
	public ResponseEntity<?> createPost(@RequestBody Post post){
		try {
			Post createdPost=postService.savePost(post);
			return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
		}
		catch(Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		
	}
	@GetMapping
	public ResponseEntity<List<Post>>getAllPosts(){
		try {
			return ResponseEntity.status(HttpStatus.OK).body(postService.getAllPosts());
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	// for VIEW count of post
	@GetMapping("/{postId}")
	public ResponseEntity<?> getPostById(@PathVariable Long postId){//we have used @PathVariable as we are searching with id
		try {
			Post post=postService.getPostById(postId);
			return ResponseEntity.ok(post);
		}
		catch(EntityNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	@PutMapping("/{postId}/like")//here postId is path
	public ResponseEntity<?> likePost(@PathVariable Long postId){
		try {
			postService.likePost(postId);
			return ResponseEntity.ok(new String[] {"post liked successfully"});
		}
		catch(EntityNotFoundException e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	
	@GetMapping("search/{name}")
	public ResponseEntity<?> searchByName(@PathVariable String name){
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(postService.searchByName(name));
		}
		catch(Exception e){
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
