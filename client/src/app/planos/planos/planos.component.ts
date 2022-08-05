import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators } from "@angular/forms";
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
      emailInstrutor: ['fabio.almendro@gmail.com'],
      estimativa: ['',Validators.required],
      nomePlano:['',Validators.required]
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

