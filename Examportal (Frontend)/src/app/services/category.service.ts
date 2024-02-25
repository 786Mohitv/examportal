import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import baseUrl from './helper';

@Injectable({
  providedIn: 'root',
})
export class CategoryService {
  constructor(private _http: HttpClient) {}
  //load all the cateogries
  public categories() {
    return this._http.get(`${baseUrl}/category/`);
  }

  //add new category
  public addCategory(category) {
    return this._http.post(`${baseUrl}/category/`, category);
  }
  
  //delete category
  public deleteCategory(id) {
    return this._http.delete(`${baseUrl}/category/${id}`);
  }

  //get category
  public getCategory(id){
    return this._http.get(`${baseUrl}/category/${id}`)
  }

  //update category
  public updateCategory(category){
  return this._http.put(`${baseUrl}/category/`, category)
  }

}
