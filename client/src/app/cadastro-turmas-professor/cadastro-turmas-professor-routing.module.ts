import { CadastroTurmasProfessorComponent } from './cadastro-turmas-professor.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '', component: CadastroTurmasProfessorComponent
  }
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class CadastroTurmasProfessorRoutingModule { }
