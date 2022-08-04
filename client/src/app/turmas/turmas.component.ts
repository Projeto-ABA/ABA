import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { Router } from '@angular/router';
import {Turma} from "../models/turma"
import {TurmaService} from "../services/turma.service"

@Component({
  selector: 'app-turmas',
  templateUrl: './turmas.component.html',
  styleUrls: ['./turmas.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class TurmasComponent implements OnInit {

  constructor(
    private router: Router,
    private turmaService : TurmaService
  ) { }
 turmas: Turma[] = [];

 coluna(c : string) :String {
  let retorno = '';
  if (c == 'nome'){
    retorno = 'Nome'
  }
  if (c == 'turno'){
    retorno = 'Turno'
  }
  if(c == 'diasDaSemana'){
    retorno = 'Dias'
  }
  return retorno;
 }

  ngOnInit(): void {
  }

  navega(caminho:string){
    this.router.navigateByUrl(caminho);
}

  goTo(item: any): void{
    console.log(item)
  }

  columnsToDisplay = ['nome', 'turno', 'diasDaSemana'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement!: Turma;
}
