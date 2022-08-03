package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoObjetivosDTOCompleto {

    private Long id;
    private String nomePlano;
    private String emailInstrutor;
    private String relacaoAtividades;
    private String descricaoAluno;
    private LocalDate estimativa;

}
