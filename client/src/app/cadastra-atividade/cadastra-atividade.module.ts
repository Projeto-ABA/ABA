import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CadastraAtividadeRoutingModule } from './cadastra-atividade-routing.module';
import { CadastraAtividadeComponent } from './cadastra-atividade/cadastra-atividade.component';
import { MatCardModule } from '@angular/material/card';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatNativeDateModule } from '@angular/material/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import {MatInputModule} from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';


@NgModule({
  declarations: [
    CadastraAtividadeComponent
  ],
  imports: [
    CommonModule,
    CadastraAtividadeRoutingModule,
    MatFormFieldModule,
    MatCardModule,
    MatNativeDateModule,
    FormsModule,
    ReactiveFormsModule,
    MatInputModule,
    MatButtonModule

  ]
})
export class CadastraAtividadeModule { }
