import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlanosDetalhesRoutingModule } from './planos-detalhes-routing.module';
import { PlanosDetalhesComponent } from './planos-detalhes/planos-detalhes.component';
import { MatCardModule } from '@angular/material/card';
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [
    PlanosDetalhesComponent
  ],
  imports: [
    CommonModule,
    PlanosDetalhesRoutingModule,
    MatCardModule,
    MatButtonModule
  ]
})
export class PlanosDetalhesModule { }
