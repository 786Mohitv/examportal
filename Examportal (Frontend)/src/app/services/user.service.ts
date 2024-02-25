import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';
import { stringify } from 'querystring';
import { JsonPipe } from '@angular/common';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor(private http: HttpClient) {}

  //add user

  public addUser(user: any) {
    return this.http.post(`${baseUrl}/user/`, user);
  }

  //getUser

  public getUser(username){
    return this.http.get(`${baseUrl}/user/${username}`)
  }

  //delete User
  public deleteUser(id){
    return this.http.delete(`${baseUrl}/user/${id}`)
  }

  //update user
  public updateUser(user:any){
    alert(JSON.stringify(user))
  return this.http.post(`${baseUrl}/user/update`, user);
  }

  //get All Users
  public getAllUsers(){
    return this.http.get(`${baseUrl}/user/getAllUsers`)
  }
}
