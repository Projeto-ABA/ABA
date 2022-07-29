import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ThemePalette } from '@angular/material/core';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {

  constructor(
    private router: Router

  ) {}

  color: ThemePalette ='accent';

  ngOnInit(): void {
  }

  user() :void{
    this.router.navigateByUrl('cadastro-usuario');
  }
  home() :void{
    this.router.navigateByUrl('home');
  }
  menu(): void{
    this.router.navigateByUrl('menu');
  }

}
