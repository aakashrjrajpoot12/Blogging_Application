package com.codeElevate.blogServer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codeElevate.blogServer.entity.Comment;
import com.codeElevate.blogServer.service.CommentService;

@RestController
@RequestMapping("/api/")
@CrossOrigin
public class Commentcontroller {

	
	@Autowired
	private CommentService commentService;
	
	
	@PostMapping("comments/create")
	public ResponseEntity<?> createComment(@RequestParam Long postId,@RequestParam String postedBy,@RequestBody String content){
		//@RequestParam for postId and postedBy: These values are simple, scalar data (like a number or string) that can easily be passed as query parameters in the URL
		//content is likely to be more complex and may represent a larger block of data (e.g., a message or a description). This type of data is better suited to being sent in the request body,
		try {
			return ResponseEntity.ok(commentService.createComment(postId,postedBy,content));
		}
		catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(e.getMessage());
		}
	}
	    
	@GetMapping("comments/{postId}")
		public ResponseEntity<?> getCommentByPostId(@PathVariable Long postId ){
			try {
				return ResponseEntity.ok(commentService.getCommentByPostId(postId));
			}
			catch (Exception e) {
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Something went wrong");
			}
	}
}
