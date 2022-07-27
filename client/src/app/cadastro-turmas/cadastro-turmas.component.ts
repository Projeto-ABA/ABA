import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-cadastro-turmas',
  templateUrl: './cadastro-turmas.component.html',
  styleUrls: ['./cadastro-turmas.component.scss']
})
export class CadastroTurmasComponent implements OnInit {

  displayedColumns: string[] = ['aluno'];

  constructor() { }

  ngOnInit(): void {
  }

}
