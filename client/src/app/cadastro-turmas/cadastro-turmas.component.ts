import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-cadastro-turmas',
  templateUrl: './cadastro-turmas.component.html',
  styleUrls: ['./cadastro-turmas.component.scss']
})
export class CadastroTurmasComponent implements OnInit {

  displayedColumns: string[] = ['aluno'];

  constructor(
    private router: Router
  ) { }

  ngOnInit(): void {
  }
  home() :void{
    this.router.navigateByUrl('home');
  }
  turmas(): void{
    this.router.navigateByUrl('turmas');
  }
  novoAluno(): void{
    this.router.navigateByUrl('cadastro-alunos');
  }
  novaTurma(): void{
    this.router.navigateByUrl('cadastro-turmas');
  }
  alunos(): void{
    this.router.navigateByUrl('alunos');
  }
  planos(): void{
    this.router.navigateByUrl('listar-planos');
  }
  novoPlano(): void{
    this.router.navigateByUrl('planos');
  }
  perfil(): void{
    this.router.navigateByUrl('perfil');
  }
}
