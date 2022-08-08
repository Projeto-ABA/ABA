import { PlanosDetalhesComponent } from './planos-detalhes/planos-detalhes.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {path:':id', component:PlanosDetalhesComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class PlanosDetalhesRoutingModule { }
