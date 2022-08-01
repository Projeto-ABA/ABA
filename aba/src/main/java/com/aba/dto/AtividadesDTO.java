package com.aba.dto;

import com.aba.model.Atividade;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AtividadesDTO {

    private List<AtividadeDTOCompleto> dadosAtividades;
    private List<Atividade> atividades;

    public AtividadesDTO (List<Atividade> atividades) {
        this.atividades = atividades;
        this.dadosAtividades = new ArrayList<>();

        for (Atividade atividade : atividades) {
            this.dadosAtividades.add(atividade.getDtoCompleto());
        }
    }
}
