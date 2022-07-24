package com.aba.model;

import com.aba.dto.AtividadeDTO;
import lombok.*;

import javax.persistence.*;

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
    private Aluno aluno;
    @ManyToOne
    private Instrutor instrutor;
    private String categoria;

    private String descricao;

    private String titulo;

    public AtividadeDTO getDto(){
        return new AtividadeDTO(this.id, this.aluno.getNome(), this.instrutor.getNome(),  this.categoria, this.descricao, this.titulo);
    }
}
