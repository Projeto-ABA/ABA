import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { HomeLoginRoutingModule } from './home-login-routing.module';


@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    HomeLoginRoutingModule,
    MatCardModule,
    MatButtonModule
  ]
})
export class HomeLoginModule { }
