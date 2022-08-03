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
public class AtividadeDTOCompleto {

    private Long id;
    private String emailInstrutor;
    private String descricao;
    private String titulo;
    private LocalDate dataRealizacao;
    private float nota;
    private String situacao;

}
