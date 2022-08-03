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

  getPlanos(){
    this.planosService.getAll().subscribe(data => {
      console.log(data)})
  }
}
