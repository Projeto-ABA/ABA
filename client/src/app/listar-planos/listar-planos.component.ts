import { getLocaleDateFormat } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { PlanoObjetivos } from '../models/PlanoObjetivos';
import { PlanoObjetivosService } from '../services/planoObjetivo.service';

@Component({
  selector: 'app-listar-planos',
  templateUrl: './listar-planos.component.html',
  styleUrls: ['./listar-planos.component.scss']
})
export class ListarPlanosComponent implements OnInit {
  planos: PlanoObjetivos[] = [];
  teste!: Date;
  ColunasTitulos = ['nomePlano','estimativa']
  constructor(
    private router: Router,
    private planosService: PlanoObjetivosService

  ) {}

  ngOnInit(): void {
    this.getPlanos();
  }
  
  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }

  coluna(c : string) :String {
    let retorno = '';
    if (c == 'nomePlano'){
      retorno = 'Nome'
    }
    if(c == 'estimativa'){
      retorno = 'Status'
    }
    return retorno;
   }

   

  getPlanos(){
    this.planosService.getAll().subscribe(planos => {
      planos.forEach(plano => {
        console.log(plano)
        this.planos.push(plano)
      })
    })
  }
}
