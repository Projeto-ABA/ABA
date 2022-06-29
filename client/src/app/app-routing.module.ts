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
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
