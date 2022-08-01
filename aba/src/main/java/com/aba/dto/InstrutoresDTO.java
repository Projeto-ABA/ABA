package com.aba.dto;

import com.aba.model.Instrutor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class InstrutoresDTO {

    private List<InstrutorDTOCompleto> dadosInstrutores;

    public InstrutoresDTO (List<Instrutor> instrutores) {
        this.dadosInstrutores = new ArrayList<>();

        for (Instrutor instrutor : instrutores) {
            dadosInstrutores.add(instrutor.getDtoCompleto());
        }
    }
}
