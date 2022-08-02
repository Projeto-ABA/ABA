import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListarPlanosComponent } from './listar-planos.component';

const routes: Routes = [
  {path: '', component: ListarPlanosComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ListarPlanosRoutingModule { }
