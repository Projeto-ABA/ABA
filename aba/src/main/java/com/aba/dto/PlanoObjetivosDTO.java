package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoObjetivosDTO {

    private String emailInstrutor;
    private String descricaoAluno;
    private String prazo;

}