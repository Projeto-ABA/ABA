package com.aba.dto;

import com.aba.model.Instrutor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.tomcat.util.digester.ArrayStack;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class InstrutoresDTO {

    private List<InstrutorDTO> dadosInstrutores;

    public InstrutoresDTO (List<Instrutor> instrutores) {
        this.dadosInstrutores = new ArrayList<>();

        for (Instrutor instrutor : instrutores) {
            dadosInstrutores.add(instrutor.getDto());
        }
    }
}
