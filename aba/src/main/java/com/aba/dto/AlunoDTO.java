package com.aba.dto;

import com.aba.model.Instrutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AlunoDTO {

    String nome;

    int idade;

    String turma;

    String instrutorEmail;
}
