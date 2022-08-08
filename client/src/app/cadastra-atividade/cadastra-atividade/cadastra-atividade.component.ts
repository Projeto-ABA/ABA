import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AtividadeService } from 'src/app/services/atividade.service';

@Component({
  selector: 'app-cadastra-atividade',
  templateUrl: './cadastra-atividade.component.html',
  styleUrls: ['./cadastra-atividade.component.scss']
})
export class CadastraAtividadeComponent implements OnInit {
  atividadeForm!: FormGroup;
  IdPlano!: number;
  constructor(
    private router: Router,
    private route: ActivatedRoute, 
    private atividadeServ: AtividadeService,
    private fb: FormBuilder    
  ) { }

  ngOnInit(): void {

    this.route.params.subscribe((objeto:any) => {
      this.IdPlano = +objeto['id'];
    })

    
    this.atividadeForm = this.fb.group({
      titulo: ['',Validators.required],
      descricao: ['',Validators.required],
      emailInstrutor: ['string'],
      dataRealização: [this.dataAtual(),Validators.required]
    })
  }

  dataAtual(): string{
    let retorno = ''
    let data = new Date().toLocaleDateString("pt-br").split("/")
    retorno = data[2]+ "-" + data[1] + "-" + data[0] 
    return retorno
  }

  cadastraAtiv(){
    this.atividadeServ.save(this.atividadeForm.value).subscribe(result => {console.log(result)})
    this.atividadeForm.reset
    this.route.params.subscribe((Id:any)=> {
      this.IdPlano = +Id['id']
    })
    this.router.navigateByUrl('')
  }

  retorna(){
    this.router.navigateByUrl('planos-detalhes/' + this.IdPlano )
  }

  navega(caminho: string){
    this.router.navigateByUrl(caminho)
  }
}
