import { Injectable } from '@angular/core';
import { Professor } from '../models/professor';
import { CrudService } from './crud.service';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class ProfessorService extends CrudService<Professor,number>{

  constructor(protected override _http: HttpClient){
    super(_http, '/api/instrutores')
  }

  override save(teste: Professor): Observable<Professor> {
    return this._http.post<Professor>('/api/instrutores', teste);
  }
}
