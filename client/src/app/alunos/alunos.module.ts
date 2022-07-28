import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon'

import { AlunosRoutingModule } from './alunos-routing.module';
import { AlunosComponent } from './alunos.component';


@NgModule({
  declarations: [
    AlunosComponent
  ],
  imports: [
    CommonModule,
    AlunosRoutingModule,
    MatCardModule,
    MatTableModule,
    MatIconModule
  ]
})
export class AlunosModule { }
