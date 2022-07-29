import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlanosRoutingModule } from './planos-routing.module';
import { PlanosComponent } from './planos/planos.component';
import { MatCardModule } from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';



@NgModule({
  declarations: [
    PlanosComponent
  ],
  imports: [
    CommonModule,
    PlanosRoutingModule,
    MatCardModule,
    MatFormFieldModule
  ]
})
export class PlanosModule { }
