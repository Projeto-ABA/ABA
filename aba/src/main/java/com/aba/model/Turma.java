package com.aba.model;
import com.aba.dto.AlunoDTOCompleto;
import com.aba.dto.TurmaDTO;
import com.aba.dto.TurmaDTOCompleto;
import lombok.*;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nomeTurma;

    @OneToOne
    private Instrutor instrutor;

    @ManyToMany
    List<Aluno> alunos;

    String turno;

    String diasDaSemana;

    public Turma(String nomeTurma, String turno, String diasDaSemana, Instrutor instrutor){
        this.nomeTurma = nomeTurma;
        this.turno = turno;
        this.diasDaSemana = diasDaSemana;
        this.instrutor = instrutor;
    }

    public void editar(TurmaDTO turmaDTO, Instrutor instrutor) {
        this.nomeTurma = turmaDTO.getNomeTurma();
        this.turno = turmaDTO.getTurno();
        this.diasDaSemana = turmaDTO.getDiasDaSemana();
        this.instrutor = instrutor;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public Object listarAlunos() {
        List<AlunoDTOCompleto> dadosAlunos = new ArrayList<>();;

        for(Aluno aluno : alunos) {
            dadosAlunos.add(aluno.getDtoCompleto());
        }
        return dadosAlunos;
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public TurmaDTO getDto(){
        return new TurmaDTO(this.nomeTurma, this.turno, this.diasDaSemana, this.instrutor.getEmail());
    }

    public TurmaDTOCompleto getDtoCompleto(){
        return new TurmaDTOCompleto(this.id, this.nomeTurma, this.instrutor.getEmail(), alunos.toString(),
                this.turno, this.diasDaSemana);
    }

}