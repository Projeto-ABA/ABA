package com.aba.model;

import com.aba.dto.PlanoObjetivosDTO;
import com.aba.dto.PlanoObjetivosDTOCompleto;
import com.aba.model.Atividade;
import com.aba.model.Instrutor;
import lombok.*;

import javax.persistence.*;
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

    @ManyToOne
    private Instrutor instrutor;

    @OneToMany
    private List<Atividade> atividades;

    private String descricaoAluno;

    private String nome;

    private String prazo; // uma alternativa aqui seria mudar para date

    public PlanoObjetivos(Instrutor instrutor, String descricaoAluno, String prazo, String nome) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.atividades = new ArrayList<>();
        this.descricaoAluno = descricaoAluno;
        this.prazo = prazo;
    }

    public void editar(PlanoObjetivosDTO planoObjetivosDTO, Instrutor instrutor) {
        this.instrutor = instrutor;
        this.descricaoAluno = planoObjetivosDTO.getDescricaoAluno();
        this.prazo = planoObjetivosDTO.getPrazo();
    }

    public void addAtividade(Atividade atividade) {
        this.atividades.add(atividade);
    }

    public void removeAtividade(Atividade atividade) { this.atividades.remove(atividade); }

    public PlanoObjetivosDTO getDto(){
        return new PlanoObjetivosDTO(this.instrutor.getEmail(), this.descricaoAluno, this.prazo, this.nome);
    }

    public PlanoObjetivosDTOCompleto getDtoCompleto(){
        return new PlanoObjetivosDTOCompleto(this.id, this.instrutor.getEmail(), atividades.toString(), this.descricaoAluno, this.prazo);
    }
}


