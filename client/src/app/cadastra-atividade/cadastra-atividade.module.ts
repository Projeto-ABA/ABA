import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastraAtividadeRoutingModule } from './cadastra-atividade-routing.module';
import { CadastraAtividadeComponent } from './cadastra-atividade/cadastra-atividade.component';


@NgModule({
  declarations: [
    CadastraAtividadeComponent
  ],
  imports: [
    CommonModule,
    CadastraAtividadeRoutingModule
  ]
})
export class CadastraAtividadeModule { }
