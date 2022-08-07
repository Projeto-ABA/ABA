import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormControl } from '@angular/forms';
import { Aluno } from '../models/aluno';
import { AlunoService } from '../services/aluno.service';
import { TurmaService } from '../services/turma.service';

@Component({
  selector: 'app-cadastro-turmas',
  templateUrl: './cadastro-turmas.component.html',
  styleUrls: ['./cadastro-turmas.component.scss']
})
export class CadastroTurmasComponent implements OnInit {

  toppings = new FormControl('');
  listaAlunos!: Aluno[];
  alunosAceitos!: Aluno[];
  constructor(
    private router: Router,
    private alunoServ: AlunoService,
    private turmaServ: TurmaService,
  ) { }

  ngOnInit(): void {
    this.alunoServ.getAlunos().subscribe(alunos => {
      this.listaAlunos = alunos;
    })
  }
  
  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }
}
