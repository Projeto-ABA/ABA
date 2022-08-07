import { Aluno } from "./aluno";

export interface Turma {

  nomeTurma : string;
  relacaoALunos : Aluno[];
  turno : string;
  diasDaSemana : string;
}
