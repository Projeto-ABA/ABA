package com.aba.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TurmaDTO {

    private String nomeTurma;
    private String turno;
    private String diasDaSemana;
    private String emailInstrutor;

}