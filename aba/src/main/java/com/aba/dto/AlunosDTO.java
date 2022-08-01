package com.aba.dto;

import java.util.ArrayList;
import java.util.List;

import com.aba.model.Aluno;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class AlunosDTO {

    private List<AlunoDTOCompleto> dadosAlunos;

    public AlunosDTO(List<Aluno> alunos) {
        this.dadosAlunos = new ArrayList<>();

        for(Aluno aluno : alunos) {
            this.dadosAlunos.add(aluno.getDtoCompleto());
        }
    }
}
