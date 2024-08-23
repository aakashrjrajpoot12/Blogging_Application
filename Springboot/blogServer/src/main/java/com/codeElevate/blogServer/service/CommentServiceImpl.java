package com.codeElevate.blogServer.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codeElevate.blogServer.entity.Comment;
import com.codeElevate.blogServer.entity.Post;
import com.codeElevate.blogServer.repository.CommentRepository;
import com.codeElevate.blogServer.repository.PostRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class CommentServiceImpl implements CommentService{
	
	@Autowired
	private CommentRepository  commentRepository;
	@Autowired
	private PostRepository postRepository;
	
	public Comment createComment(Long postId,String postedBy, String content) {
		// we have passed arguments like postId,postedBy,content as it is required in project
		Optional <Post> optionalPost=postRepository.findById(postId);
		if(optionalPost.isPresent()) {
			Comment comment = new Comment(); //If the post exists, a new Comment object is created.
			comment.setPost(optionalPost.get());
			comment.setContent(content);
			comment.setPostedBy(postedBy);
			comment.setCreatedAt(new Date());
			return commentRepository.save(comment);
		}
		throw new EntityNotFoundException("Post not found");
	}
	
	
	public List<Comment>getCommentByPostId(Long postId){
		  //This method retrieves all comments associated with a specific post.
         return commentRepository.findByPostId(postId);
           //to fetch and return the list of comments associated with the specified post ID.
	}

}
