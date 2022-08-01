package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlunoDTOCompleto {

    private Long id;
    private String nome;
    private int idade;
    private String relacaoPlanosObjetivos;
    private String emailInstrutor;
    private String contato;
    private String genero;
    private String cpf;
    private String endereco;
    private String responsavel;
    private String parentesco;

}