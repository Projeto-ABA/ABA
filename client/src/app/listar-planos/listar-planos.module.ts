import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarPlanosRoutingModule } from './listar-planos-routing.module';
import { ListarPlanosComponent } from './listar-planos.component';
import { MatCardModule } from '@angular/material/card';
import { MatDividerModule } from '@angular/material/divider'
import { MatTableModule } from '@angular/material/table';
import {MatPaginatorModule} from '@angular/material/paginator';
import { MatIconModule } from '@angular/material/icon';
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [
    ListarPlanosComponent
  ],
  imports: [
    CommonModule,
    ListarPlanosRoutingModule,
    MatCardModule,
    MatDividerModule,
    MatTableModule,
    MatPaginatorModule,
    MatIconModule,
    MatButtonModule
  ]
})
export class ListarPlanosModule { }
