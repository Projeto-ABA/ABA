import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PerfilRoutingModule } from './perfil-routing.module';
import { PerfilComponent } from './perfil/perfil.component';
import { MatCardModule } from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [
    PerfilComponent
  ],
  imports: [
    CommonModule,
    PerfilRoutingModule,
    MatCardModule,
    MatFormFieldModule,
    MatButtonModule
  ]
})
export class PerfilModule { }


