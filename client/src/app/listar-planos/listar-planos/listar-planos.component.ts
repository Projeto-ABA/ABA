import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-listar-planos',
  templateUrl: './listar-planos.component.html',
  styleUrls: ['./listar-planos.component.scss']
})
export class ListarPlanosComponent implements OnInit {
  obDesenvolvimento = 0;
  obRealizados = 0;
  constructor() { 
    
  }

  ngOnInit(): void {
  }

}
