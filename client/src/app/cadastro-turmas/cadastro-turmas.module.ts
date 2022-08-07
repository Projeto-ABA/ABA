import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroTurmasRoutingModule } from './cadastro-turmas-routing.module';
import { CadastroTurmasComponent } from './cadastro-turmas.component';
import { MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatSelectModule } from '@angular/material/select';
import { MatOptionModule } from '@angular/material/core';
import { MatNativeDateModule } from '@angular/material/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatListModule } from '@angular/material/list';



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
    MatOptionModule,
    MatNativeDateModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,
    MatListModule
  ]
})
export class CadastroTurmasModule { }
