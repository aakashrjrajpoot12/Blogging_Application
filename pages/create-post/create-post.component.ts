import { Component } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-create-post',
  templateUrl: './create-post.component.html',
  styleUrls: ['./create-post.component.scss']
})
export class CreatePostComponent {
  postForm!:FormGroup;//creating form groupwhich name as postForm
tags:string[]=[];//array with name tags which is empty



  constructor(private fb:FormBuilder,//FormBuilder for reactive form
    private router: Router,//Router to redirect our users to component
    private snackBar: MatSnackBar,//MatSnackBar to show msg
    private postService: PostService,
  ){}
  //we need to mention controls for postform so we need to declare method ngOnInit
ngOnInit(){
  this.postForm=this.fb.group({ //in this method we will use postform and formbuilder and also group method
    //below mentioned are our controls
    name:[null,Validators.required],//default value we will check for null,for validator we will check for Validators.required
    content:[null,Validators.required,Validators.maxLength(5000)],//for content we will check for Validators.maxLength(5000)
    img:[null,Validators.required],
    postedBy:[null,Validators.required]
  })
  
}
add(event:any){
  const value=(event.value ||'').trim();
  if(value){
    this.tags.push(value);
  }
  event.chipInput!.clear();
}
remove(tag:any){
  const index=this.tags.indexOf(tag);
  if(index>=0){
    this.tags.splice(index,1);
  }
  }
  createPost(){
    const data =this.postForm.value;
    data.tags=this.tags;
    this.postService.createNewPost(data).subscribe(res=>{
      this.snackBar.open("Post Created Successfully !!!!","OK");
      this.router.navigateByUrl("/");
    },error=>{
      this.snackBar.open("Something Went Wrong!!!","ok")
    })
    
  
  }
}
