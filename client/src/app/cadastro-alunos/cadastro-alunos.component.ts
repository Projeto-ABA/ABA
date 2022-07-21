import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-alunos',
  templateUrl: './cadastro-alunos.component.html',
  styleUrls: ['./cadastro-alunos.component.scss']
})
export class CadastroAlunosComponent implements OnInit {


  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  home() :void{
    this.router.navigateByUrl('home');
  }

}
