package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private String nome;
    private LocalDate dataNascimento;
    private String cid;
    private String emailInstrutor;
    private String contato;
    private String genero;
    private String cpf;
    private String endereco;
    private String responsavel;
    private String parentesco;

}