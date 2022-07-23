import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroTurmasRoutingModule } from './cadastro-turmas-routing.module';
import { CadastroTurmasComponent } from './cadastro-turmas.component';
import { MatCardModule } from '@angular/material/card';

@NgModule({
  declarations: [
    CadastroTurmasComponent
  ],
  imports: [
    CommonModule,
    CadastroTurmasRoutingModule,
    MatCardModule
  ]
})
export class CadastroTurmasModule { }
