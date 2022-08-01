package com.aba.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PlanoObjetivosDTOCompleto {

    private Long id;
    private String emailInstrutor;
    private String relacaoAtividades;
    private String descricaoAluno;
    private String prazo; // talvez mudar p date depois...

}
