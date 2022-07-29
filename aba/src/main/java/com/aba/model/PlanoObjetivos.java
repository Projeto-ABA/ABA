package com.aba.model;

import com.aba.dto.PlanoObjetivosDTO;
import com.aba.enums.Avaliacao;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlanoObjetivos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Aluno aluno;

    @ManyToOne
    @JoinColumn(name = "idInstrutor")
    private Instrutor instrutor;

    @OneToMany
    private Map<String, Atividade> atividades = new HashMap<>();

    private String descricaoAluno;

    public void addAtividade(Avaliacao avaliacao, Atividade atividade) {
        this.atividades.put(avaliacao.getDescricao(), atividade);
    }

    public PlanoObjetivosDTO getDto(){
        return new PlanoObjetivosDTO(this.aluno.getNome(), this.instrutor.getNome(), toString(), this.descricaoAluno);
    }

    public String toString(){
        if (this.atividades.size() >= 1) {
            List<String> atividades_formated = new ArrayList<>();
            for (Map.Entry<String, Atividade> atividade: atividades.entrySet()){
                String model = "{" + atividade.getKey() + "}" + atividade.getValue().getTitulo();
                atividades_formated.add(model);
            }
            return String.join("\n", atividades_formated);
        }
        return "{Sem atividades ainda!}";
    }
}
