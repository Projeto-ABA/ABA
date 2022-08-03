import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aluno } from '../models/aluno';
import { CrudService } from './crud.service';

@Injectable({
  providedIn: 'root'
})
export class AlunoService {

  private readonly API = 'api/alunos'

  constructor(
    private httpClient : HttpClient
  ){

  }
  getAlunos() : Observable<Aluno[]> {
    return this.httpClient.get<Aluno[]>(this.API + '/listar');
  }

}
