import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { PlanosRoutingModule } from './planos-routing.module';
import { PlanosComponent } from './planos/planos.component';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';





@NgModule({
  declarations: [
    PlanosComponent,
  ],
  imports: [
    CommonModule,
    PlanosRoutingModule,
    MatCardModule,
    MatFormFieldModule,
    MatNativeDateModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule,      
  ]
})
export class PlanosModule { }
