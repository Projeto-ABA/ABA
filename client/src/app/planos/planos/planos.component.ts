import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, NgForm, Validators } from "@angular/forms";
import { PlanoObjetivos } from 'src/app/models/PlanoObjetivos';
import { PlanoObjetivosService } from 'src/app/services/planoObjetivo.service';

@Component({
  selector: 'app-planos',
  templateUrl: './planos.component.html',
  styleUrls: ['./planos.component.scss']
})
export class PlanosComponent implements OnInit {
  planosForm!: FormGroup;

  constructor(
    private router: Router,
    private po: PlanoObjetivosService,
    private fb: FormBuilder
    ) {}

  ngOnInit(): void {
    this.planosForm = this.fb.group({
      descricaoAluno: ['',Validators.required],
      emailInstrutor: ['teste.exemplo'],
      prazo: ['',Validators.required],
      nome:['']     
    })
  }

  createPlano(){
    console.log(this.planosForm.value)
    this.po.save(this.planosForm.value).subscribe(result => {})
    this.planosForm.reset(); 
  }

  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }
}

