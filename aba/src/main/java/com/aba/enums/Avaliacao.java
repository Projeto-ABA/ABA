package com.aba.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum Avaliacao {

    // NA - Não Avaliada
    NAO_AVALIADA("NA"),
    OTIMA("ÓTIMA"),
    BOA("BOA"),
    MEDIANA("MEDIANA"),
    RUIM("RUIM");

    private String descricao;
    Avaliacao (String avalicao) {
        this.descricao = avalicao;
    }
}
