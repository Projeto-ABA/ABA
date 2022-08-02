import { Injectable } from "@angular/core";
import { HttpClient, HttpParams } from '@angular/common/http';
import { PlanoObjetivos } from "../models/PlanoObjetivos";
import { CrudService } from "./crud.service";

@Injectable({
    providedIn: 'root'
})
export class PlanoObjetivosService extends CrudService<PlanoObjetivos,number>{

    constructor(protected override _http: HttpClient){
        super(_http, '/api/planoObjetivos');
    }

}