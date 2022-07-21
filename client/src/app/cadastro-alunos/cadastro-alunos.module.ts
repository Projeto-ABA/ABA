import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule } from '@angular/material/card';

import { CadastroAlunosRoutingModule } from './cadastro-alunos-routing.module';
import { CadastroAlunosComponent } from './cadastro-alunos.component';


@NgModule({
  declarations: [
    CadastroAlunosComponent
  ],
  imports: [
    CommonModule,
    CadastroAlunosRoutingModule,
    MatCardModule

  ]
})
export class CadastroAlunosModule { }
