import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Turma } from '../models/turma';
import { CrudService } from './crud.service';

@Injectable({
  providedIn: 'root'
})
export class TurmaService extends CrudService<Turma,number>{

  constructor(protected override _http: HttpClient){
    super(_http, 'api/turmas')
  }

  getTurmas() : Observable<Turma[]> {
    return this._http.get<Turma[]>(this._base + '/listar');
  }

  addAlunoTurma(turmaId: number, alunoId:number) : Observable<Turma> {
    return this._http.put<Turma>(this._base + '/adicionar-aluno/' , turmaId + '/' + alunoId)
  }
}
