package com.aba.model;

import com.aba.dto.AlunoDTO;
import com.aba.dto.AlunoDTOCompleto;
import lombok.*;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
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

    private LocalDate dataNascimento;
    private int idade;

    private String cid;

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

    public Aluno(String nome, LocalDate dataNascimento, String cid, Instrutor instrutor, String contato, String genero, String cpf, String endereco, String responsavel, String parentesco) {
        super(nome);
        this.dataNascimento = dataNascimento;
        this.idade = this.calcularIdade(dataNascimento);
        this.cid = cid;
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
        this.dataNascimento = alunoDTO.getDataNascimento();
        this.idade = this.calcularIdade(alunoDTO.getDataNascimento());
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
        return new AlunoDTO(this.nome, this.dataNascimento, this.cid, this.instrutor.getEmail(), this.contato, this.genero, this.cpf,
                this.endereco, this.responsavel, this.parentesco);
    }

    public AlunoDTOCompleto getDtoCompleto(){
        return new AlunoDTOCompleto(this.id, this.nome, this.idade, this.planosDeObjetivo.toString(),
                this.instrutor.getEmail(), this.contato, this.genero, this.cpf, this.endereco, this.responsavel,
                this.parentesco);
    }

    private int calcularIdade(LocalDate dataNascimento) {
        final LocalDate dataAtual = LocalDate.now();
        final Period periodo = Period.between(dataNascimento, dataAtual);

        return periodo.getYears();
    }
}