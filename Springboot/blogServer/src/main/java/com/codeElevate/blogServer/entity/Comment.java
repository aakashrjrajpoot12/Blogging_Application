package com.codeElevate.blogServer.entity;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
//AFTER providing all details in this entity class you can see that entity table is created in db,blog_server>>expanding tables you will see comments
//Initially comment table will be empty but after posting comment on post it will be visible in db

@Entity
@Data
public class Comment {
    @Id
    @GeneratedValue (strategy=GenerationType.IDENTITY)
    private long id;
    private String content;
    private Date createdAt;
    private String postedBy;
    
    @ManyToOne //one post can have many comment
    @JoinColumn(name="post_id",nullable=false)//name="post_id": This specifies the name of the foreign key column in the comments table. 
    //It tells the ORM framework that this column (post_id) will hold the ID of the Post entity that the Comment is associated with.
    //nullable=false: This indicates that the post_id column cannot be null, meaning every comment must be associated with a post.
    private Post post;

    
    
	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", content=" + content + ", createdAt=" + createdAt + ", postedBy=" + postedBy
				+ ", post=" + post + "]";
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getPostedBy() {
		return postedBy;
	}

	public void setPostedBy(String postedBy) {
		this.postedBy = postedBy;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}

    
    


}
