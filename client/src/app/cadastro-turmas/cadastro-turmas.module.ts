import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroTurmasRoutingModule } from './cadastro-turmas-routing.module';
import { CadastroTurmasComponent } from './cadastro-turmas.component';
import { MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';

@NgModule({
  declarations: [
    CadastroTurmasComponent
  ],
  imports: [
    CommonModule,
    CadastroTurmasRoutingModule,
    MatCardModule,
    MatTableModule,
    MatFormFieldModule,
    MatSelectModule,
    MatOptionModule
  ]
})
export class CadastroTurmasModule { }
