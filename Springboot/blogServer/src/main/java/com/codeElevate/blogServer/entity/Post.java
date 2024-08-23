package com.codeElevate.blogServer.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
;

@Entity
@Data
public class Post {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//AUTOMATIC ID GENERAION ,it will automatically upgrade id value
private long id;
private String name;
@Column(length=5000)
private String content;
private String postedBy;
private String image;
private List<String> tags;
private Date date;
private int likeCount;
private int viewCount;






public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getPostedBy() {
	return postedBy;
}
public void setPostedBy(String postedBy) {
	this.postedBy = postedBy;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public List<String> getTags() {
	return tags;
}
public void setTags(List<String> tags) {
	this.tags = tags;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}
public int getLikeCount() {
	return likeCount;
}
public void setLikeCount(int likeCount) {
	this.likeCount = likeCount;
}
public int getViewCount() {
	return viewCount;
}
public void setViewCount(int viewCount) {
	this.viewCount = viewCount;
}



  




}
