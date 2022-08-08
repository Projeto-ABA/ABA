import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Atividade } from '../models/atividade';
import { CrudService } from './crud.service';

@Injectable({
  providedIn: 'root'
})
export class AtividadeService extends CrudService<Atividade, number>{


  constructor(protected override _http: HttpClient){
    super(_http, 'api/atividades')
  }

  getAtividade(): Observable<Atividade[]> {
    return this._http.get<Atividade[]>(this._base + '/listar')
  }

}
