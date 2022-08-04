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
public class PlanoObjetivosDTO {

    private String nomePlano;
    private String emailInstrutor;
    private String descricaoAluno;
    private LocalDate estimativa;

}