import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TurmasRoutingModule } from './turmas-routing.module';
import { TurmasComponent } from './turmas.component';
import {MatCardModule } from '@angular/material/card';
import {MatTableModule} from '@angular/material/table';
import {MatIconModule} from '@angular/material/icon'

@NgModule({
  declarations: [
    TurmasComponent
  ],
  imports: [
    CommonModule,
    TurmasRoutingModule,
    MatCardModule,
    MatTableModule,
    MatIconModule
  ]
})
export class TurmasModule { }
