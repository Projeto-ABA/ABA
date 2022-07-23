package com.aba.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.aba.dto.AlunoDTO;

import com.aba.dto.AlunoTotalInfoDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Aluno extends Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int idade;

    //@ManyToOne
    private String turma; //Temporariamente criado como string enquanto n existe o crud de turma

    @ManyToMany
    private List<Atividade> atividades;

    @ManyToOne
    private Instrutor instrutor;

    public Aluno(String nome, int idade, String turma, Instrutor instrutor) {
        super(nome);

        this.idade = idade;
        this.turma = turma;
        this.instrutor = instrutor;
        this.atividades = new ArrayList<>();
    }

    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public void editar(String nome, int idade, String turma, Instrutor instrutor) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setTurma(turma);
        this.setInstrutor(instrutor);

        this.nome = nome != null ? nome : this.nome;
    }

    public AlunoTotalInfoDTO getTotalDto() {
        return new AlunoTotalInfoDTO(this.id, this.nome, this.idade, this.turma, this.instrutor.getEmail());
    }

    public AlunoDTO getDto() {
        return new AlunoDTO(this.nome, this.idade, this.turma, this.instrutor.getEmail());
    }
}
