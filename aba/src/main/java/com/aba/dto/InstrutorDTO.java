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
public class InstrutorDTO {

    private String nome;
    private String sobrenome;
    private LocalDate dataNascimento;
    private String email;
    private String cpf;
    private String telefone;
    private String instituição;
}
