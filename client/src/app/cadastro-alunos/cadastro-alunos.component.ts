import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, NgForm, Validators } from "@angular/forms";
import { AlunoService } from '../services/aluno.service';

@Component({
  selector: 'app-cadastro-alunos',
  templateUrl: './cadastro-alunos.component.html',
  styleUrls: ['./cadastro-alunos.component.scss']
})
export class CadastroAlunosComponent implements OnInit {


  constructor(
    private router: Router,
    private fb: FormBuilder,
    private alunoService : AlunoService
    ) { }

  alunoForm!: FormGroup;

  ngOnInit(): void {
    this.alunoForm = this.fb.group({
      nome: ['',Validators.required],
      emailInstrutor: ['teste.exemplo'],
      nascimento: ['',Validators.required],
      genero: ['',Validators.required],
      cid: ['',Validators.required],
      cpf: ['',Validators.required],
      endereco: ['',Validators.required],
      contato: ['',Validators.required],
      responsavel: ['',Validators.required],
      parentesco: ['',Validators.required]
    })
  }
  createAluno() : void{
    this.alunoService.save(this.alunoForm.value).subscribe(result => {
      console.log(result)
    });
    this.alunoForm.reset();
  }

  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }

}
