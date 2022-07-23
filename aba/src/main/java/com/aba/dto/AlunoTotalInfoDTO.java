package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlunoTotalInfoDTO {

    Long id;

    String nome;

    int idade;

    String turma;

    String emailInstrutor;
}
