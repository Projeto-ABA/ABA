package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtividadeDTOEditar {

    private String emailInstrutor;
    private String descricao;
    private String titulo;
    private String dataRealizacao;
    private float nota;
    private String situacao;

}