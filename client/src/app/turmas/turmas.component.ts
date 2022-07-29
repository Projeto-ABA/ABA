import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';
import { Router } from '@angular/router';


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
    this.router.navigateByUrl('planos');
  }
  perfil(): void{
    this.router.navigateByUrl('perfil');
  }
  goTo(item: any): void{
    console.log(item)
  }
  dataSource = ELEMENT_DATA;
  columnsToDisplay = ['Nome', 'Turno', 'Dias'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement!: Aluno | null;
}

export interface Aluno {
  Nome: string;
  position: number;
  Turno: string;
  Dias: string;

}

const ELEMENT_DATA: Aluno[] = [
  {
    position: 1,
    Nome: 'Hydrogen',
    Turno: 'Manhã',
    Dias: 'Seg-Sex'
  },
  {
    position: 2,
    Nome: 'Helium',
    Turno: 'Tarde',
    Dias: 'Ter-Qui'
  },
  {
    position: 3,
    Nome: 'Lithium',
    Turno: 'Manhã',
    Dias: 'Qua-Sex'
  },
  {
    position: 4,
    Nome: 'Beryllium',
    Turno:'Tarde',
    Dias: 'Segunda'
  },
  {
    position: 5,
    Nome: 'Boron',
    Turno:'Manhã',
    Dias: 'Quarta'
  },
  {
    position: 6,
    Nome: 'Carbon',
    Turno: 'Tarde',
    Dias: 'Seg-Ter-Qua',

  },
  {
    position: 7,
    Nome: 'Nitrogen',
    Turno: 'Manhã',
    Dias: 'Todos os dias'
  },
  {
    position: 8,
    Nome: 'Oxygen',
    Turno: 'Tarde',
    Dias: 'Terça'
  },
  {
    position: 9,
    Nome: 'Fluorine',
    Turno: 'Manhã',
    Dias: 'Quinta'
  },
  {
    position: 10,
    Nome: 'Neon',
    Turno: 'Tarde',
    Dias: 'Sexta'
  },
];
