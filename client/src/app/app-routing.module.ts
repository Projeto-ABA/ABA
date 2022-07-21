import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'home'
  },

  {
    path: 'home',
    loadChildren: () => import('./home/home-logout/home-logout.module').then(m => m.HomeLogoutModule)
  },

  {
    path: 'menu',
    loadChildren: () => import('./home/home-login/home-login.module').then(m => m.HomeLoginModule)
  },

  {path: 'turmas',
    loadChildren: () => import('./turmas/turmas.module').then(m => m.TurmasModule)
  },

  {
    path: 'cadastro-turmas-professor',
    loadChildren: () => import('./cadastro-turmas-professor/cadastro-turmas-professor.module').then(m => m.CadastroTurmasProfessorModule)
  },

  {
    path: 'cadastro-alunos',
    loadChildren: () => import('./cadastro-alunos/cadastro-alunos.module').then(m => m.CadastroAlunosModule)
  },

  {
    path: 'cadastro-turmas-coordenador',
    loadChildren: () => import('./cadastro-turmas-coordenador/cadastro-turmas-coordenador.module').then(m => m.CadastroTurmasCoordenadorModule)
  },

  {
    path: 'listar-alunos',
    loadChildren: () => import('./listar-alunos/listar-alunos.module').then(m => m.ListarAlunosModule)
  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

