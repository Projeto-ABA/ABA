package com.aba.model;

import com.aba.dto.AlunoDTO;
import com.aba.dto.AlunoDTOCompleto;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany
    private List<PlanoObjetivos> planosDeObjetivo;

    @ManyToOne
    private Instrutor instrutor;

    private String contato;

    private String genero; // isso pode ser um enum

    private String cpf;

    private String endereco;

    private String responsavel;

    private String parentesco;

    public Aluno(String nome, int idade, Instrutor instrutor, String contato, String genero, String cpf, String endereco, String responsavel, String parentesco) {
        super(nome);
        this.idade = idade;
        this.instrutor = instrutor;
        this.planosDeObjetivo = new ArrayList<>();
        this.contato = contato;
        this.genero = genero;
        this.cpf = cpf;
        this.endereco = endereco;
        this.responsavel = responsavel;
        this.parentesco = parentesco;
    }

    public void editar(AlunoDTO alunoDTO, Instrutor instrutor) {
        this.nome = alunoDTO.getNome();
        this.idade = alunoDTO.getIdade();
        this.instrutor = instrutor;
        this.contato = alunoDTO.getContato();
        this.genero = alunoDTO.getGenero();
        this.cpf = alunoDTO.getCpf();
        this.endereco = alunoDTO.getEndereco();
        this.responsavel = alunoDTO.getResponsavel();
        this.parentesco = alunoDTO.getParentesco();
    }

    public void addPlanoObjetivo(PlanoObjetivos planoObjetivos) {
        this.planosDeObjetivo.add(planoObjetivos);
    }
    public void removePlanoObjetivo(PlanoObjetivos planoObjetivos) {
        this.planosDeObjetivo.remove(planoObjetivos);
    }

    public AlunoDTO getDto(){
        return new AlunoDTO(this.nome, this.idade, this.instrutor.getEmail(), this.contato, this.genero, this.cpf,
                this.endereco, this.responsavel, this.parentesco);
    }

    public AlunoDTOCompleto getDtoCompleto(){
        return new AlunoDTOCompleto(this.id, this.nome, this.idade, this.planosDeObjetivo.toString(),
                this.instrutor.getEmail(), this.contato, this.genero, this.cpf, this.endereco, this.responsavel,
                this.parentesco);
    }
}