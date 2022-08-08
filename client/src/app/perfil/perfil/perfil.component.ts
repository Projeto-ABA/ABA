import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-perfil',
  templateUrl: './perfil.component.html',
  styleUrls: ['./perfil.component.scss']
})
export class PerfilComponent implements OnInit {

  constructor(private router: Router) { }

  ngOnInit(): void {
  }
  navega(caminho:string) {
    this.router.navigateByUrl(caminho);
  }
}
