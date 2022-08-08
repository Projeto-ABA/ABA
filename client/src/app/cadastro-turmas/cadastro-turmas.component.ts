import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Aluno } from '../models/aluno';
import { AlunoService } from '../services/aluno.service';
import { TurmaService } from '../services/turma.service';

@Component({
  selector: 'app-cadastro-turmas',
  templateUrl: './cadastro-turmas.component.html',
  styleUrls: ['./cadastro-turmas.component.scss']
})
export class CadastroTurmasComponent implements OnInit {

  turmaForm!: FormGroup;
  listaAlunos!: Aluno[];
  alunosAceitos!: Aluno[];

  constructor(
    private router: Router,
    private alunoServ: AlunoService,
    private turmaServ: TurmaService,
    private fb: FormBuilder,
  ) { }

  ngOnInit(): void {
    this.alunoServ.getAlunos().subscribe(alunos => {
      this.listaAlunos = alunos;
    })

    this.turmaForm = this.fb.group({
      nomeTurma: ['',Validators.required],
      emailInstrutor: ['string'],
      turno: ['',Validators.required],
      diasDaSemana: ['', Validators.required]
    })
  }
  
  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }

  cadastraTurma(){
    this.turmaServ.save(this.turmaForm.value).subscribe(result => console.log(result))
    this.navega('turmas')
  }
}

