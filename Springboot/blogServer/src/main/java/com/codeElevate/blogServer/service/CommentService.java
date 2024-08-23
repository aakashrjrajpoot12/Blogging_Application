package com.codeElevate.blogServer.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codeElevate.blogServer.entity.Comment;
@Service
public interface CommentService {
	
	Comment createComment(Long postId,String postedBy, String content);
	 List<Comment>getCommentByPostId(Long postId);
}
