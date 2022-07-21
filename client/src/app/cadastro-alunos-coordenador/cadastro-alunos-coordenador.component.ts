import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-alunos-coordenador',
  templateUrl: './cadastro-alunos-coordenador.component.html',
  styleUrls: ['./cadastro-alunos-coordenador.component.scss']
})
export class CadastroAlunosCoordenadorComponent implements OnInit {


  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  home() :void{
    this.router.navigateByUrl('home');
  }

}
