import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home-login',
  templateUrl: './home-login.component.html',
  styleUrls: ['./home-login.component.scss']
})
export class HomeLoginComponent implements OnInit {

  constructor(
    private router: Router
  ) {

  }

  ngOnInit(): void {
  }

  home() :void{
    this.router.navigateByUrl('home');
  }

  addAluno() :void{
    this.router.navigateByUrl('cadastro-alunos');
  }

  alunos() :void{
    this.router.navigateByUrl('alunos');
  }

}
