import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-view-all',
  templateUrl: './view-all.component.html',
  styleUrls: ['./view-all.component.scss']
})
export class ViewAllComponent {
  allPosts: any;  //to store response of getAllPosts() API

  constructor(private postService:PostService,
private snackBar:MatSnackBar){}

//we need to mention controls for postform so we need to declare method ngOnInit
ngOnInit(){
  this.getAllPosts();
}
  getAllPosts(){
    this.postService.getAllPosts().subscribe(res=>{
      console.log(res);
      this.allPosts=res;
    },error=>{
      this.snackBar.open("something went wrong!!!!","OK")
    })
  }
}
