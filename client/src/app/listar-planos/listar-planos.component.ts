import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-listar-planos',
  templateUrl: './listar-planos.component.html',
  styleUrls: ['./listar-planos.component.scss']
})
export class ListarPlanosComponent implements OnInit {
  obDesenvolvimento = 0;
  obRealizados = 0;
  constructor(
    private router: Router
  ) {

  }

  ngOnInit(): void {
  }
  
  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }
}
