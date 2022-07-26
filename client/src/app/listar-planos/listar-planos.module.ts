import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListarPlanosRoutingModule } from './listar-planos-routing.module';
import { ListarPlanosComponent } from './listar-planos/listar-planos.component';


@NgModule({
  declarations: [
    ListarPlanosComponent
  ],
  imports: [
    CommonModule,
    ListarPlanosRoutingModule
  ]
})
export class ListarPlanosModule { }
