import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Aluno } from '../models/aluno';
import { CrudService } from './crud.service';

@Injectable({
  providedIn: 'root'
})
export class AlunoService extends CrudService<Aluno, number>{


  constructor(protected override _http: HttpClient){
    super(_http, 'api/alunos')
  }

  getAlunos() : Observable<Aluno[]> {
    return this._http.get<Aluno[]>(this._base + '/listar');
  }

}
