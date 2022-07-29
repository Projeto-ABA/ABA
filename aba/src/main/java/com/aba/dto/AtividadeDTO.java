package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeDTO {

    Long id;
    String nomeAluno;
    String nomeInstrutor;
    String categoria;
    String descricao;
    String titulo;

}
