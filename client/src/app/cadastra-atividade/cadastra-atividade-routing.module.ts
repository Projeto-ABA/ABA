import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CadastraAtividadeComponent } from './cadastra-atividade/cadastra-atividade.component';

const routes: Routes = [
  {path: '', component: CadastraAtividadeComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastraAtividadeRoutingModule { }
