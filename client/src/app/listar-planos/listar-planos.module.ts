import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarPlanosRoutingModule } from './listar-planos-routing.module';
import { ListarPlanosComponent } from './listar-planos.component';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider'
import { MatTableModule } from '@angular/material/table';


@NgModule({
  declarations: [
    ListarPlanosComponent
  ],
  imports: [
    CommonModule,
    ListarPlanosRoutingModule,
    MatCardModule,
    MatDividerModule,
    MatTableModule
  ]
})
export class ListarPlanosModule { }
