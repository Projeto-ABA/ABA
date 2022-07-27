import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.scss']
})
export class CadastroUsuarioComponent implements OnInit {

  constructor(
    private router: Router

  ) {}


  ngOnInit(): void {
  }

  home() :void{
    this.router.navigateByUrl('home');
  }
}
