package com.aba.dto;

import com.aba.model.PlanoObjetivos;
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
public class PlanosObjetivosDTO {

    List<PlanoObjetivosDTOCompleto> dadosPlanosObjetivos;
    List<PlanoObjetivos> aux;

    public PlanosObjetivosDTO (List<PlanoObjetivos> planoObjetivosList) {
        this.dadosPlanosObjetivos = new ArrayList<>();
        this.aux = planoObjetivosList;

        for (PlanoObjetivos plano: planoObjetivosList) {
            this.dadosPlanosObjetivos.add(plano.getDtoCompleto());
        }
    }

}
