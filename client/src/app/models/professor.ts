import { Turma } from "./turma";

export interface Professor {
  id:number;
  nome : string;
  sobrenome: string;
  cpf: string;
  dataNasc : Date;
  email : string;
  telefone: string;
  instituição: string;
}
