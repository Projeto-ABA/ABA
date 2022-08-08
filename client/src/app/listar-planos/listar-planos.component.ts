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
  planos!: PlanoObjetivos[];
  ColunasTitulos = ['nomePlano','estimativa','options'];
  Data = new Date();
  countAtual = 0;
  countRealizado = 0;
  
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

  colunaNome(c : string) :String {
    let retorno = '';
    if (c == 'nomePlano'){
      retorno = 'Nome'
    }
    if(c == 'estimativa'){
      retorno = 'Status'
    }
    return retorno;
   }

   formata(dataPlano:Array<number>):String{
    let retorno = '';
    let data = this.Data.toLocaleDateString("pt-br")
    let dataAtual = (data.split("/"))
    if (dataPlano[0] >= parseInt(dataAtual[2]) && dataPlano[1] >= parseInt(dataAtual[1]) && dataPlano[2] >= parseInt(dataAtual[0]) ){
      this.countAtual = this.countAtual + 1;
      retorno = "Atual"
    }
    else { 
      this.countRealizado = this.countRealizado + 1;
      retorno = "Encerrado";
    }
    
    return retorno
   }  

  getPlanos(){
    this.planosService.getAll().subscribe(planos => {
      console.log(planos)
      this.planos = planos;
    })
  }

  planosDetalhes(planoId: string){
    this.router.navigateByUrl('planos-detalhes/' + planoId); 
  }
}
