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
    path: 'cadastro-alunos',
    loadChildren: () => import('./cadastro-alunos/cadastro-alunos.module').then(m => m.CadastroAlunosModule)
  },

  {
    path: 'cadastro-turmas',
    loadChildren: () => import('./cadastro-turmas/cadastro-turmas.module').then(m => m.CadastroTurmasModule)
  },

  {
    path: 'alunos',
    loadChildren: () => import('./alunos/alunos.module').then(m => m.AlunosModule)
  },

  {
    path: 'planos',
    loadChildren: () => import('./planos/planos.module').then(m => m.PlanosModule)
  },

  {
    path: 'listar-planos',
    loadChildren: () => import('./listar-planos/listar-planos.module').then(m => m.ListarPlanosModule)
  },

  {
    path: 'planos-detalhes',
    loadChildren: () => import('./planos-detalhes/planos-detalhes.module').then(m => m.PlanosDetalhesModule)
  },

  {
    path: 'perfil',
    loadChildren: () => import('./perfil/perfil.module').then(m => m.PerfilModule)
  },

  {
    path: 'cadastra-atividade',
    loadChildren: () => import('./cadastra-atividade/cadastra-atividade.module').then(m => m.CadastraAtividadeModule)

  },
  {
    path: 'login',
    loadChildren: () => import('./login/login/login.module').then(m => m.LoginModule)

  },
  {
    path: 'user',
    loadChildren: () => import('./login/user/user.module').then(m => m.UserModule)

  }

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {}

