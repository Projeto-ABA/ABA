import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule } from '@angular/material/card';

import { CadastroAlunosCoordenadorRoutingModule } from './cadastro-alunos-coordenador-routing.module';
import { CadastroAlunosCoordenadorComponent } from './cadastro-alunos-coordenador.component';


@NgModule({
  declarations: [
    CadastroAlunosCoordenadorComponent
  ],
  imports: [
    CommonModule,
    CadastroAlunosCoordenadorRoutingModule,
    MatCardModule

  ]
})
export class CadastroAlunosCoordenadorModule { }
