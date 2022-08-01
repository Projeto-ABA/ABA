package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TurmaDTOCompleto {

    private Long id;

    private String nomeTurma;

    private String emailInstrutor;

    private String relacaoALunos;

    private String turno;

    private String diasDaSemana;
}