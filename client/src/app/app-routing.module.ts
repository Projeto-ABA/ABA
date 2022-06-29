import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
  {
    path: '', pathMatch: 'full', redirectTo: 'home'
  },
  
  {
    path: 'home',
    loadChildren: () => import('./app.module').then(m => m.AppModule)
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
