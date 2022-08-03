package com.aba.model;

import com.aba.dto.PlanoObjetivosDTO;
import com.aba.dto.PlanoObjetivosDTOCompleto;
import com.aba.model.Atividade;
import com.aba.model.Instrutor;
import lombok.*;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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

    private String nomePlano;

    @ManyToOne
    private Instrutor instrutor;

    @OneToMany
    private List<Atividade> atividades;

    private String descricaoAluno;

    private LocalDate estimativa;

    public PlanoObjetivos(String nomePlano, Instrutor instrutor, String descricaoAluno, LocalDate estimativa) {
        this.nomePlano = nomePlano;
        this.instrutor = instrutor;
        this.atividades = new ArrayList<>();
        this.descricaoAluno = descricaoAluno;
        this.estimativa = estimativa;
    }

    public void editar(PlanoObjetivosDTO planoObjetivosDTO, Instrutor instrutor) {
        this.nomePlano = planoObjetivosDTO.getNomePlano();
        this.instrutor = instrutor;
        this.descricaoAluno = planoObjetivosDTO.getDescricaoAluno();
        this.estimativa = planoObjetivosDTO.getEstimativa();
    }

    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public void removeAtividade(Atividade atividade) { this.atividades.remove(atividade); }

    public PlanoObjetivosDTO getDto(){
        return new PlanoObjetivosDTO(this.nomePlano, this.instrutor.getEmail(), this.descricaoAluno, this.estimativa);
    }

    public PlanoObjetivosDTOCompleto getDtoCompleto(){
        return new PlanoObjetivosDTOCompleto(this.id, this.nomePlano, this.instrutor.getEmail(), atividades.toString(), this.descricaoAluno, this.estimativa);
    }
}


