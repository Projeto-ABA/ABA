import { Aluno } from "./aluno";

export interface Turma {
  emailInstrutor: string
  nomeTurma : string;
  relacaoALunos : Aluno[];
  turno : string;
  diasDaSemana : string;
}
