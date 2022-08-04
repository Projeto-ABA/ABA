package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTO {

    private String nome;
    private int idade;
    private String emailInstrutor;
    private String contato;
    private String genero;
    private String cpf;
    private String endereco;
    private String responsavel;
    private String parentesco;

}