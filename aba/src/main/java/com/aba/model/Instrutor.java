package com.aba.model;

import com.aba.dto.InstrutorDTO;
import com.aba.dto.InstrutorDTOCompleto;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;

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
    private String sobrenome;
    private LocalDate dataNascimento;
    private int idade;
    private String email;
    private String cpf;
    private String telefone;
    private String instituição;
    private String senha;

    public Instrutor(String nome, String sobrenome, LocalDate dataNascimento, String email,
                     String cpf, String telefone, String instituição) {
        super(nome);
        this.sobrenome = sobrenome;
        this.dataNascimento = dataNascimento;
        this.idade = this.calcularIdade(dataNascimento);
        this.email = email;
        this.cpf = cpf;
        this.telefone = telefone;
        this.instituição = instituição;
    }

    public Instrutor(InstrutorDTO instrutorDTO) {
        super(instrutorDTO.getNome());
        this.sobrenome = instrutorDTO.getSobrenome();
        this.dataNascimento = instrutorDTO.getDataNascimento();
        this.idade = this.calcularIdade(instrutorDTO.getDataNascimento());
        this.email = instrutorDTO.getEmail();
        this.cpf = instrutorDTO.getCpf();
        this.telefone = instrutorDTO.getTelefone();
        this.instituição = instrutorDTO.getInstituição();
    }

    public void editar(InstrutorDTO instrutorDTO) {
        setNome(instrutorDTO.getNome());
        setSobrenome(instrutorDTO.getSobrenome());
        setDataNascimento(instrutorDTO.getDataNascimento());
        setIdade(this.calcularIdade(instrutorDTO.getDataNascimento()));
        setEmail(instrutorDTO.getEmail());
        setCpf(instrutorDTO.getCpf());
        setTelefone(instrutorDTO.getTelefone());
        setInstituição(instrutorDTO.getInstituição());
    }

    public InstrutorDTO getDto() {
        return new InstrutorDTO(this.nome, this.sobrenome,
                this.dataNascimento, this.email, this.cpf,
                this.telefone, this.instituição);
    }

    public InstrutorDTOCompleto getDtoCompleto() {
        return new InstrutorDTOCompleto(this.id, this.nome, this.sobrenome,
                this.dataNascimento, this.idade, this.email, this.cpf,
                this.telefone, this.instituição);
    }

    private int calcularIdade(LocalDate dataNascimento) {
        final LocalDate dataAtual = LocalDate.now();
        final Period periodo = Period.between(dataNascimento, dataAtual);

        return periodo.getYears();
    }
}