import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
const BASIC_URL='http://localhost:8080/';
@Injectable({
  providedIn: 'root'
})
export class CommentService {

  constructor( private http:HttpClient) { }
  createComment(postId:number,postedBy:string,content: string):Observable<any>{
    //return type is observable of any type
    const params={   //const params: This is a JavaScript object that holds key-value pairs representing the parameters postId and postedBy that you want to include in the HTTP request.
      postId:postId,
      postedBy:postedBy,
    }
    return this.http.post<any>(BASIC_URL+`api/comments/create`,content,{params});//{ params }: This is an options object where the params key specifies the query parameters that will be appended to the URL.
    //This means that the server will receive the postId and postedBy as query parameters in the request URL
    }
    getAllCommentsByPost(postId:number):Observable<any>{
      return this.http.get(BASIC_URL+`api/comments/${postId}`);
    }
}
