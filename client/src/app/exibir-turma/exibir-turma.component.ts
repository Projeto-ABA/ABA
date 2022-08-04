import { Aluno } from './../models/aluno';
import { AlunoService } from './../services/aluno.service';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import {animate, state, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-exibir-turma',
  templateUrl: './exibir-turma.component.html',
  styleUrls: ['./exibir-turma.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ]
})

export class ExibirTurmaComponent implements OnInit {

  constructor(
    private router: Router,
    private alunoService: AlunoService
    ) { }

    alunos: Aluno[] = [];

    coluna(c : string) :String {
      let retorno = '';
      if (c == 'nome'){
        retorno = 'Nome'
      }
      if (c == 'idade'){
        retorno = 'Idade'
      }
      if(c == 'cid'){
        retorno = 'CID'
      }
      return retorno;
     }

  columnsToDisplay = ['nome', 'idade', 'cid'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement!: Aluno;

  ngOnInit(): void {
  }

  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }

}
