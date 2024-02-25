import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.css']
})
export class UpdateUserComponent implements OnInit {

 
  username=null;
  user;
  toUpdate={
    "id": 0,
    "username": "",
    "password": "",
    "firstName": "",
    "lastName": "",
    "email": "",
    "phone": "",
    "enabled": true,
    "profile": ""
};
  constructor(
    private _route: ActivatedRoute,
    private _user: UserService,
    private _router: Router) { }

  ngOnInit(): void {
    this._route.params.subscribe(params => {
      this.username = params['username'];
      // alert(this.username);
    });
    this._user.getUser(this.username).subscribe(
      (data: any) => {
        this.user = data;
        console.log(this.user);
      },
      (error) => {
        console.log(error);
      }
    );
  }

  public updateData() {
    //validatate
    this.toUpdate.id=this.user.id
    this.toUpdate.username=this.user.username
    this.toUpdate.lastName=this.user.lastName
    this.toUpdate.firstName=this.user.firstName
    this.toUpdate.password=this.user.password
    this.toUpdate.email=this.user.email
    this.toUpdate.phone=this.user.phone
    this.toUpdate.enabled=this.user.enabled
    this.toUpdate.profile=this.user.profile
    this._user.updateUser(this.toUpdate).subscribe(
      (data) => {
        this._router.navigate(['/admin/users']);
        Swal.fire('Success !!', 'user updated', 'success').then((e) => {
        });
      },
      (error) => {
        Swal.fire('Error', 'error in updating user', 'error');
        console.log(error);
      }
    );
  }

}
