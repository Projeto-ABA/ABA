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

    public Aluno(AlunoDTO alunoDTO) {
        super(alunoDTO.getNome());
        this.idade = alunoDTO.getIdade();
        this.turma = alunoDTO.getTurma();
        this.instrutor.editar(alunoDTO.getInstrutorDTO());
        this.atividades = new ArrayList<>();
    }

    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public void editar(AlunoDTO alunoDTO) {
        String nome = alunoDTO.getNome();
        this.idade = alunoDTO.getIdade();
        this.turma = alunoDTO.getTurma();
        this.instrutor.editar(alunoDTO.getInstrutorDTO());

        this.nome = nome != null ? nome : this.nome;
    }

    public AlunoDTO getDto() {
        return new AlunoDTO(this.nome, this.idade, this.turma, this.instrutor.getDto());
    }
}
