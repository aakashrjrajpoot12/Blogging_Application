import { Component } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-search-by-name',
  templateUrl: './search-by-name.component.html',
  styleUrls: ['./search-by-name.component.scss']
})
export class SearchByNameComponent {
result:any=[];//1st create result variable of type any with empty array

name:any= "";//2nd variable to store search keyword

constructor(private postService : PostService,   //3rd create constructor
private snackbar:MatSnackBar){}


searchByName(){ 
  this.postService.searchByName(this.name).subscribe(res=>{    //4th in body of method we will use 
   this.result=res; //Incase of success we need to update our result
   console.log(this.result);
   
  },error=>{
    this.snackbar.open("something went wrong!!!","OK")
  }
)
}
}
