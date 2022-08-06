import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
import { Router } from '@angular/router';
import { ProfessorService } from '../services/professor.service';

@Component({
  selector: 'app-cadastro-usuario',
  templateUrl: './cadastro-usuario.component.html',
  styleUrls: ['./cadastro-usuario.component.scss']
})
export class CadastroUsuarioComponent implements OnInit {

  professorForm !: FormGroup;

  constructor(
    private router: Router,
    private profService: ProfessorService,
    private fb:FormBuilder,

  ) {}


  ngOnInit(): void {
    this.professorForm = this.fb.group({
      nome : ['', Validators.required],
      sobrenome: ['', Validators.required],
      cpf: ['', Validators.required],
      dataNasc : ['', Validators.required],
      email : ['', Validators.required],
      telefone: ['', Validators.required],
      instituicao: ['', Validators.required]
    })
  }

  home() :void{
    this.router.navigateByUrl('home');
  }

  cadastra() :void{
    console.log(this.professorForm.value)
    this.profService.save(this.professorForm.value).subscribe(result => {})
    
  }
}
