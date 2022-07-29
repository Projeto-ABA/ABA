package com.aba.model;

import com.aba.dto.InstrutorDTO;
import lombok.*;
import javax.persistence.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Instrutor extends Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int idade;
    private String email;

    public Instrutor (String nome, int idade, String email) {
        super(nome);
        this.idade = idade;
        this.email = email;
    }

    public Instrutor (InstrutorDTO instrutorDTO) {
        super(instrutorDTO.getNome());
        this.idade = instrutorDTO.getIdade();
        this.email = instrutorDTO.getEmail();
    }

    public void editar(InstrutorDTO instrutorDTO) {
        this.nome = instrutorDTO.getNome();
        this.idade = instrutorDTO.getIdade();
        this.email = instrutorDTO.getEmail();
    }

    public InstrutorDTO getDto() {
        return new InstrutorDTO(this.nome, this.idade, this.email);
    }
}