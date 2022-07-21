import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroTurmasCoordenadorRoutingModule } from './cadastro-turmas-coordenador-routing.module';
import { CadastroTurmasCoordenadorComponent } from './cadastro-turmas-coordenador.component';
import { MatCardModule } from '@angular/material/card';

@NgModule({
  declarations: [
    CadastroTurmasCoordenadorComponent
  ],
  imports: [
    CommonModule,
    CadastroTurmasCoordenadorRoutingModule,
    MatCardModule
  ]
})
export class CadastroTurmasCoordenadorModule { }
