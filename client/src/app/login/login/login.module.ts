import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { LoginRoutingModule } from './login-routing.module';
import {MatProgressSpinnerModule} from '@angular/material/progress-spinner';
import { LoginComponent } from './login.component';
import { MatCardModule } from '@angular/material/card';
import { ReactiveFormsModule } from '@angular/forms';
import { MatIconModule } from '@angular/material/icon';



@NgModule({
  declarations: [
    LoginComponent,


  ],
  imports: [
    MatCardModule,
    CommonModule,
    LoginRoutingModule,
    MatProgressSpinnerModule,
    ReactiveFormsModule,
    MatIconModule
  ]
})
export class LoginModule { }
