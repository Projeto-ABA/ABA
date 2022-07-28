import { Component, OnInit } from '@angular/core';
import {animate, state, style, transition, trigger} from '@angular/animations';

@Component({
  selector: 'app-alunos',
  templateUrl: './alunos.component.html',
  styleUrls: ['./alunos.component.scss'],
  animations: [
    trigger('detailExpand', [
      state('collapsed', style({height: '0px', minHeight: '0'})),
      state('expanded', style({height: '*'})),
      transition('expanded <=> collapsed', animate('225ms cubic-bezier(0.4, 0.0, 0.2, 1)')),
    ]),
  ],
})
export class AlunosComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

  dataSource = ELEMENT_DATA;
  columnsToDisplay = ['Nome', 'Idade', 'CID'];
  columnsToDisplayWithExpand = [...this.columnsToDisplay, 'expand'];
  expandedElement!: Aluno | null;
}

export interface Aluno {
  Nome: string;
  position: number;
  Idade: number;
  CID: string;

}

const ELEMENT_DATA: Aluno[] = [
  {
    position: 1,
    Nome: 'Hydrogen',
    Idade: 1.0079,
    CID: 'H'
  },
  {
    position: 2,
    Nome: 'Helium',
    Idade: 4.0026,
    CID: 'He'
  },
  {
    position: 3,
    Nome: 'Lithium',
    Idade: 6.941,
    CID: 'Li'
  },
  {
    position: 4,
    Nome: 'Beryllium',
    Idade: 9.0122,
    CID: 'Be'
  },
  {
    position: 5,
    Nome: 'Boron',
    Idade: 10.811,
    CID: 'B'
  },
  {
    position: 6,
    Nome: 'Carbon',
    Idade: 12.0107,
    CID: 'C',

  },
  {
    position: 7,
    Nome: 'Nitrogen',
    Idade: 14.0067,
    CID: 'N'
  },
  {
    position: 8,
    Nome: 'Oxygen',
    Idade: 15.9994,
    CID: 'O'
  },
  {
    position: 9,
    Nome: 'Fluorine',
    Idade: 18.9984,
    CID: 'F'
  },
  {
    position: 10,
    Nome: 'Neon',
    Idade: 20.1797,
    CID: 'Ne'
  },
];


