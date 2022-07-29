package com.aba.model;

import com.aba.dto.TurmaTotalInfoDTO;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import com.aba.dto.TurmaDTO;
import com.aba.model.Aluno;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    List<Instrutor> instrutores;

    @ManyToMany
    List<Aluno> alunos;

    private String nome;


    public Turma(String nome) {
        this.nome = nome;
        this.instrutores = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public Turma(TurmaDTO turmaDTO) {
        this.nome = turmaDTO.getNomeTurma();
        this.instrutores = new ArrayList<>();
        this.alunos = new ArrayList<>();
    }

    public void adicionarAluno(Aluno aluno) {
        this.alunos.add(aluno);
    }

    public void adicionarInstrutor(Instrutor instrutor) {
        this.instrutores.add(instrutor);
    }

    public void removerAluno(Aluno aluno) {
        this.alunos.remove(aluno);
    }

    public void removerInstrutor(Instrutor instrutor) {
        this.instrutores.remove(instrutor);
    }

    public String listarAlunos() { return this.alunos.toString(); }
    public String listarInstrutores() { return this.instrutores.toString(); }
    public TurmaDTO getDto(){ return new TurmaDTO(this.nome); }
    public TurmaTotalInfoDTO getDtoTotal() {
        return new TurmaTotalInfoDTO(this.id, this.nome);
    }

}
