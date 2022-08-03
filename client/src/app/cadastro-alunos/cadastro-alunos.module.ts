import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { CadastroAlunosRoutingModule } from './cadastro-alunos-routing.module';
import { CadastroAlunosComponent } from './cadastro-alunos.component';


@NgModule({
  declarations: [
    CadastroAlunosComponent
  ],
  imports: [
    CommonModule,
    CadastroAlunosRoutingModule,
    MatFormFieldModule,
    MatNativeDateModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatCardModule

  ]
})
export class CadastroAlunosModule { }
