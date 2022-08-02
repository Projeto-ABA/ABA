import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-planos',
  templateUrl: './planos.component.html',
  styleUrls: ['./planos.component.scss']
})
export class PlanosComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }
}
