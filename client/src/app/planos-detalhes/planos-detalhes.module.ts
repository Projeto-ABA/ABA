import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlanosDetalhesRoutingModule } from './planos-detalhes-routing.module';
import { PlanosDetalhesComponent } from './planos-detalhes/planos-detalhes.component';


@NgModule({
  declarations: [
    PlanosDetalhesComponent
  ],
  imports: [
    CommonModule,
    PlanosDetalhesRoutingModule
  ]
})
export class PlanosDetalhesModule { }
