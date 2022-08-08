import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Atividade } from 'src/app/models/atividade';
import { PlanoObjetivos } from 'src/app/models/PlanoObjetivos';
import { AtividadeService } from 'src/app/services/atividade.service';
import { PlanoObjetivosService } from 'src/app/services/planoObjetivo.service';

@Component({
  selector: 'app-turmas',
  templateUrl: './planos-detalhes.component.html',
  styleUrls: ['./planos-detalhes.component.scss']
})
export class PlanosDetalhesComponent implements OnInit {
  plano!: PlanoObjetivos;
  instrutor!: string;
  idPlano!: number;
  listaAtiv!: Atividade[];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private planoServ: PlanoObjetivosService,
    private atividadeServ: AtividadeService
  ) { }

  ngOnInit(): void {
    
    this.route.params.subscribe((objeto:any) => {
      this.idPlano = +objeto['id'];
    })
    console.log(this.idPlano)
    this.planoServ.findOne(this.idPlano).subscribe(dado => {
      this.plano = dado;
    })

    this.listaAtividade();
    
  }

  navega(caminho:string){
    this.router.navigateByUrl(caminho);
  }

  navegaAtividade(){
    this.router.navigateByUrl('cadastra-atividade/' + this.idPlano)
  }

  formata(data: Array<number>) : string{
    let retorno = data[2] + "/"+ data[1] + "/" + data[0]
    return retorno
  }

  listaAtividade() {
    this.atividadeServ.getAtividade().subscribe(atividades => {
      this.listaAtiv = atividades
      console.log(this.listaAtiv)
    })
  }
}
