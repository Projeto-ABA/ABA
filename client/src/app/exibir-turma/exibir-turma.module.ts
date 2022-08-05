import { ExibirTurmaComponent } from './../exibir-turma/exibir-turma.component';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon';
import { ExibirTurmaRoutingModule } from './exibir-turma-routing.module';


@NgModule({
  declarations: [
    ExibirTurmaComponent
  ],
  imports: [
    CommonModule,
    ExibirTurmaRoutingModule,
    MatCardModule,
    MatTableModule,
    MatIconModule
  ]
})
export class ExibirTurmaModule { }
