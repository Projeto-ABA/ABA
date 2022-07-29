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

    @ManyToOne
    private Turma turma;

    @ManyToMany
    private List<Atividade> atividades;
   // private List<PlanoObjetivos> planoObjetivos;

    @ManyToOne
    private Instrutor instrutor;

    private String contato;

    private String genero;

    private String cpf;

    private String endereco;

    private String responsavel;

    private String parentesco;

    public Aluno(String nome, int idade, Turma turma, Instrutor instrutor) {
   // public Aluno(String nome, int idade, Instrutor instrutor, String contato,
                 //String genero, String cpf, String endereco, String responsavel, String parentesco) {
        super(nome);

        this.idade = idade;
        this.turma = null;
        this.instrutor = instrutor;
        this.atividades = new ArrayList<>();
       // this.planoObjetivos = new ArrayList<>();
        this.contato = contato;
        this.genero = genero;
        this.cpf = cpf;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.parentesco = parentesco;
    }

   // public void addPlanoObjetivo(PlanoObjetivos planoObjetivos) {
     //   this.planoObjetivos.add(planoObjetivos);
   // }

    public void editar(String nome, int idade, Turma turma, Instrutor instrutor) {
        this.setNome(nome);
        this.setIdade(idade);
        this.setInstrutor(instrutor);

        this.nome = nome != null ? nome : this.nome;
    }

    public void novaTurma(Turma turma){
        this.setTurma(turma);
    }

    public AlunoTotalInfoDTO getTotalDto() {
        return new AlunoTotalInfoDTO(this.id, this.nome, this.idade, this.turma.getNome(), this.instrutor.getEmail());
    }

    public AlunoDTO getDto() {
        return new AlunoDTO(this.nome, this.idade, this.turma.getNome(), this.instrutor.getEmail());
    }

}
