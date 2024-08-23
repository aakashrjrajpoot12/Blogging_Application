import { CommaExpr } from '@angular/compiler';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { ActivatedRoute } from '@angular/router';
import { CommentService } from 'src/app/services/comment.service';

import { PostService } from 'src/app/services/post.service';
        
           
@Component({
  selector: 'app-view-post',
  templateUrl: './view-post.component.html',
  styleUrls: ['./view-post.component.scss']
})
export class ViewPostComponent {
//2nd create after constructor
  postId=this.activatedRoute.snapshot.params['id'];//postId is variable ,and we will set value in it by using activatedRoute after this we will call snapshot and then params and here we need to mentione variable name which is Id
  postData: any;
  comments:any;
  commentForm!:FormGroup;  //Step1 
//create 1st create object of commentForm!
  constructor(
  private postService:PostService,
  private activatedRoute:ActivatedRoute,
  private matSnackBar:MatSnackBar,
  private fb: FormBuilder,//Step2  Inject formbuilder inside constructor
  private commentService:CommentService
){}
//3rd create after postId
ngOnInit(){
  console.log(this.postId);
  //5th after getPostById
  this.getPostById();
  //Step3   inside ngoninit we will use commentform and after this we will use form builder and 
  this.commentForm=this.fb.group({ // step4 inside group method we need to mention our controls 
    postedBy:[null,Validators.required],
    content:[null,Validators.required]
  })
}
//Step5 ,We need method to call our API 
publishComment(){
  // in this method we need to get values by
  const postedBy=this.commentForm.get('postedBy')?.value;
  const content=this.commentForm.get('content')?.value;
  this.commentService.createComment(this.postId,postedBy,content).subscribe(res=>{
    this.matSnackBar.open("Comment Published Successfully!!!","OK")
    this.getCommentsByPost();
  },error=>{
    this.matSnackBar.open("Something went wrong!!!","OK")
  })
}



getCommentsByPost(){
  this.commentService.getAllCommentsByPost(this.postId).subscribe(res=>{
    this.comments=res;// In case of Success we need to store in res
  },error=>{
    this.matSnackBar.open("Something went wrong!!!","OK")

  })
}
//4th after NgOnInit
getPostById(){
  this.postService.getPostById(this.postId).subscribe(res=>{//subscribe is used to handle HTTP requests. It allows you to define what should happen when the data is successfully retrieved, when an error occurs, or when the observable completes.
    //res(short for "response") is the data returned by the API when the HTTP request is successful.

    this.postData=res;
    console.log(res);
    this.getCommentsByPost();
  },error=>{
    this.matSnackBar.open("something Went Wromg!!!","OK")
  })
}



likePost(){
  this.postService.likePost(this.postId).subscribe(res=>{
    this.matSnackBar.open("post liked successfully","OK")
    this.getPostById();
  },error=>{
    this.matSnackBar.open("something Went Wromg!!!","OK")
  })

}
}
