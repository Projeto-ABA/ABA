package com.aba.model;

import com.aba.dto.AtividadeDTO;
import com.aba.dto.AtividadeDTOCompleto;
import com.aba.dto.AtividadeDTOEditar;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Atividade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Instrutor instrutor;

    private String descricao;

    private String titulo;

    private LocalDate dataRealizacao;

    private float nota = -1; // caso a nota ainda não tenha sido corrigida, ela será "-1"

    private String situacao = "NÃO AVALIADA";

    public Atividade(Instrutor instrutor, String descricao, String titulo, LocalDate dataRealizacao) {
        this.instrutor = instrutor;
        this.descricao = descricao;
        this.titulo = titulo;
        this.dataRealizacao = dataRealizacao;
    }

    public void editar(AtividadeDTOEditar atividadeDTOCompleto, Instrutor instrutor) {
        this.instrutor = instrutor;
        this.descricao = atividadeDTOCompleto.getDescricao();
        this.titulo = atividadeDTOCompleto.getTitulo();
        this.dataRealizacao = atividadeDTOCompleto.getDataRealizacao();
        this.nota = atividadeDTOCompleto.getNota();
        this.situacao = atividadeDTOCompleto.getSituacao();
    }

    public AtividadeDTO getDto(){
        return new AtividadeDTO(this.instrutor.getEmail(), this.descricao, this.titulo, this.dataRealizacao);
    }

    public AtividadeDTOCompleto getDtoCompleto() {
        return new AtividadeDTOCompleto(this.id, this.instrutor.getEmail(),  this.descricao, this.titulo,
                this.dataRealizacao, this.nota, this.situacao);
    }
}
