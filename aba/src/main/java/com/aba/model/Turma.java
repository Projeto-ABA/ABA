package com.aba.model;
import com.aba.dto.TurmaDTO;
import com.aba.dto.TurmaDTOCompleto;
import lombok.*;
import javax.persistence.*;
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

    public Turma(String nomeTurma, String turno, String diasDaSemana){
        this.nomeTurma = nomeTurma;
        this.turno = turno;
        this.diasDaSemana = diasDaSemana;

        instrutor.setEmail("");
    }

    public Turma(TurmaDTO turmaDTO) {
        this.nomeTurma = turmaDTO.getNomeTurma();
        this.turno = turmaDTO.getTurno();
        this.diasDaSemana = turmaDTO.getDiasDaSemana();
    }

    public void addInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public void addAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public TurmaDTO getDto(){
        return new TurmaDTO(this.nomeTurma, this.turno, this.diasDaSemana);
    }

    public TurmaDTOCompleto getDtoCompleto(){
       String aux = "";

        if (this.instrutor == null) {
            return new TurmaDTOCompleto(this.id, this.nomeTurma, "", alunos.toString(),
                    this.turno, this.diasDaSemana);
        }

        return new TurmaDTOCompleto(this.id, this.nomeTurma, this.instrutor.getEmail(), alunos.toString(),
                this.turno, this.diasDaSemana);
    }
}