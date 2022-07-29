import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CadastraAtividadeRoutingModule } from './cadastra-atividade-routing.module';
import { CadastraAtividadeComponent } from './cadastra-atividade/cadastra-atividade.component';
import { MatCardModule } from '@angular/material/card';
import {MatFormFieldModule} from '@angular/material/form-field';


@NgModule({
  declarations: [
    CadastraAtividadeComponent
  ],
  imports: [
    CommonModule,
    CadastraAtividadeRoutingModule,
    MatFormFieldModule,
    MatCardModule

  ]
})
export class CadastraAtividadeModule { }
