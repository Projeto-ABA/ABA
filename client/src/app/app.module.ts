import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatCardModule} from '@angular/material/card';
import {MatButtonModule} from '@angular/material/button';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { HomeLogoutComponent } from './home/home-logout/home-logout.component';
import { HomeLoginComponent } from './home/home-login/home-login.component';
import {MatIconModule} from '@angular/material/icon';
import { EditarAlunoComponent } from './editar-aluno/editar-aluno.component';
import { EditarTurmaComponent } from './editar-turma/editar-turma.component';




@NgModule({
  declarations: [
    AppComponent,
    HomeLogoutComponent,
    HomeLoginComponent,
    EditarAlunoComponent,
    EditarTurmaComponent
   ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MatCardModule,
    MatButtonModule,
    BrowserAnimationsModule,
    MatIconModule,

  ],
  providers: [
    ],
  bootstrap: [AppComponent]
})
export class AppModule { }
