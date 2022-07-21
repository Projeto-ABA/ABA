import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroTurmasProfessorRoutingModule } from './cadastro-turmas-professor-routing.module';
import { CadastroTurmasProfessorComponent } from './cadastro-turmas-professor.component';


@NgModule({
  declarations: [
    CadastroTurmasProfessorComponent
  ],
  imports: [
    CommonModule,
    CadastroTurmasProfessorRoutingModule
  ]
})
export class CadastroTurmasProfessorModule { }
