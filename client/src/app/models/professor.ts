import { Turma } from "./turma";

export interface Professor {
  id : number;
  nome : number;
  idade : number;
  email : number;
  turmas : Turma[];
}
