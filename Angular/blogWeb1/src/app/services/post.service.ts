import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';


const BASIC_URL='http://localhost:8080/';

@Injectable({
  providedIn: 'root'
})
export class PostService {

  constructor(private http:HttpClient) { }

  //We are creating api
    createNewPost(data:any):Observable<any>{
      return this.http.post(BASIC_URL + `api/posts` , data);//basic_url+endpoint(here + icon will concatinate string)
               //here data is request body
    }
    getAllPosts():Observable<any>{
      return this.http.get(BASIC_URL + `api/posts` );
    }
    getPostById(postId:number):Observable<any>{
      return this.http.get(BASIC_URL + `api/posts/${postId}` );//here "api/posts/${postId}" api url
                    //$ is used here as you have to provide input of id which you want to serach 
    }
    likePost(postId:number):Observable<any>{
      return this.http.put(BASIC_URL + `api/posts/${postId}/like`,{} );// request body is {}, which is empyty
    }
    searchByName(name:string):Observable<any>{
      return this.http.get(BASIC_URL + `api/posts/search/${name}` );//here "api/posts/${postId}" api url
    }
    
  }

