import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CategoryService } from 'src/app/services/category.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-category',
  templateUrl: './update-category.component.html',
  styleUrls: ['./update-category.component.css']
})
export class UpdateCategoryComponent implements OnInit {

  cid = 0;
  category;

  constructor(
    private _route: ActivatedRoute,
    private _cat: CategoryService,
    private _router: Router) { }

  ngOnInit(): void {
    this.cid = this._route.snapshot.params.cid;
    // alert(this.cid)
    this._cat.getCategory(this.cid).subscribe(
      (data: any) => {
        this.category = data;
        console.log(this.category);
      },
      (error) => {
        console.log(error);
      }
    );
  }


  public updateData() {
    //validatate

    this._cat.updateCategory(this.category).subscribe(
      (data) => {
        this._router.navigate(['/admin/categories']);
        Swal.fire('Success !!', 'category updated', 'success').then((e) => {
        });
      },
      (error) => {
        Swal.fire('Error', 'error in updating categories', 'error');
        console.log(error);
      }
    );
  }

}
