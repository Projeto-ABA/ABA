import { MatCardModule } from '@angular/material/card';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroUsuarioRoutingModule } from './cadastro-usuario-routing.module';
import { CadastroUsuarioComponent } from './cadastro-usuario.component';
import { MatIconModule } from '@angular/material/icon';



@NgModule({
  declarations: [
    CadastroUsuarioComponent
  ],
  imports: [
    CommonModule,
    CadastroUsuarioRoutingModule,
    MatIconModule,
    MatCardModule
  ]
})
export class CadastroUsuarioModule { }
