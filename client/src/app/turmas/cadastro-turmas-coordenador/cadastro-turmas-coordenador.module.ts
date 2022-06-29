import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroTurmasCoordenadorRoutingModule } from './cadastro-turmas-coordenador-routing.module';
import { CadastroTurmasCoordenadorComponent } from './cadastro-turmas-coordenador/cadastro-turmas-coordenador.component';


@NgModule({
  declarations: [
    CadastroTurmasCoordenadorComponent
  ],
  imports: [
    CommonModule,
    CadastroTurmasCoordenadorRoutingModule
  ]
})
export class CadastroTurmasCoordenadorModule { }
