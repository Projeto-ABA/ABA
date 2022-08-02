import { Aluno } from "./aluno";

export interface Turma {
  id : number;
  nomeTurma : string;
  relacaoALunos : Aluno[];
  turno : string;
  diasDaSemana : string;
}
