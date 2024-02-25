import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-users',
  templateUrl: './users.component.html',
  styleUrls: ['./users.component.css']
})
export class UsersComponent implements OnInit {

  users = [];

  constructor(private _userService: UserService) { }

  ngOnInit(): void {
    this._userService.getAllUsers().subscribe(
      (data: any) => {
        //css
        this.users = data;
        console.log(this.users);
      },

      (error) => {
        //
        console.log(error); 
        Swal.fire('Error !!', 'Error in loading data', 'error');
      }
    );
  }

  deleteUser(uid) {
    Swal.fire({
      icon: 'info',
      title: 'Are you sure ?',
      confirmButtonText: 'Delete',
      showCancelButton: true,
    }).then((result) => {
      if (result.isConfirmed) {
        //delete...
        
        this._userService.deleteUser(uid).subscribe(
          (data) => {
            this.users = this.users.filter((user) => user.cid != uid);
            window.location.reload();
            Swal.fire('Success', 'User deleted ', 'success');
          },
          (error) => {
            Swal.fire('Error', 'Error in deleting user', 'error');
          }
        );
      }
    });
  }

}
