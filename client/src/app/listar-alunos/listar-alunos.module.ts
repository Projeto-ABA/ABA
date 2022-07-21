import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ListarAlunosRoutingModule } from './listar-alunos-routing.module';
import { ListarAlunosComponent } from './listar-alunos.component';


@NgModule({
  declarations: [
    ListarAlunosComponent
  ],
  imports: [
    CommonModule,
    ListarAlunosRoutingModule
  ]
})
export class ListarAlunosModule { }
