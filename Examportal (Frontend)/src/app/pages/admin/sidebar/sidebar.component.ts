import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from 'src/app/services/login.service';

@Component({
  selector: 'app-sidebar',
  templateUrl: './sidebar.component.html',
  styleUrls: ['./sidebar.component.css']
})
export class SidebarComponent implements OnInit {

  constructor(private login:LoginService,
    private router:Router) { }

  ngOnInit(): void {
  }
  public logout() {
    this.login.logout();
    this.router.navigate(['/login']);
    // this.login.loginStatusSubject.next(false);
  }
}
