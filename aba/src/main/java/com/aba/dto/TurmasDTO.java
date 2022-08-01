package com.aba.dto;

import com.aba.model.Instrutor;
import com.aba.model.Turma;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class TurmasDTO {

    private List<TurmaDTOCompleto> dadosTurma;

    public TurmasDTO (List<Turma> turmas) {
        this.dadosTurma = new ArrayList<>();

        for (Turma turma : turmas) {
            dadosTurma.add(turma.getDtoCompleto());
        }
    }

}
