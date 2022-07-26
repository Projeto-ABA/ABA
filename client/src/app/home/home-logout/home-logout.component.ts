import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-logout',
  templateUrl: './home-logout.component.html',
  styleUrls: ['./home-logout.component.scss']
})
export class HomeLogoutComponent implements OnInit {

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }

  login(): void{
    this.router.navigateByUrl('login');
  }

}
