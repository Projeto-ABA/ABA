package com.aba.controller;


import com.aba.util.InputVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aba.dto.AlunoDTO;
import com.aba.interfaces.AlunoService;

import io.swagger.annotations.Api;

@RestController
@RequestMapping("/api/alunos")
@Api
public class AlunoAPIController {

    @Autowired
    AlunoService alunoService;

    @PostMapping("")
    public ResponseEntity<?> cadastrarAluno(@RequestBody AlunoDTO alunoDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDeAlunoDTO(alunoDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.alunoService.cadastrarAluno(alunoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDeAlunoDTO(alunoDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.alunoService.editarAluno(id, alunoDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarAluno(@PathVariable Long id) {
        return this.alunoService.consultarAluno(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerAluno(@PathVariable Long id) {
        return this.alunoService.removerAluno(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarAlunos() {
        return this.alunoService.listarAlunos();
    }

    private ResponseEntity<?> verificacaoGenericaDeAlunoDTO(AlunoDTO alunoDTO) {

        ResponseEntity<?> nomeVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getNome(),
                "nome",
                99);

        if (nomeVerification != null) {
            return nomeVerification;
        }

        ResponseEntity<?> cidVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getCid(),
                "cid",
                99);

        if (cidVerification != null) {
            return cidVerification;
        }
        ResponseEntity<?> emailInstrutorVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getEmailInstrutor(),
                "email instrutor",
                99);

        if (emailInstrutorVerification != null) {
            return emailInstrutorVerification;
        }

        ResponseEntity<?> contatoVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getContato(),
                "contato",
                99);

        if (contatoVerification != null) {
            return contatoVerification;
        }

        ResponseEntity<?> generoVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getGenero(),
                "genero",
                99);

        if (generoVerification != null) {
            return generoVerification;
        }

        ResponseEntity<?> cpfVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getNome(),
                "cpf",
                99);

        if (cpfVerification != null) {
            return cpfVerification;
        }

        ResponseEntity<?> enderecoVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getNome(),
                "endereço",
                99);

        if (enderecoVerification != null) {
            return enderecoVerification;
        }

        ResponseEntity<?> responsavelVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getNome(),
                "responsavel",
                99);

        if (responsavelVerification != null) {
            return responsavelVerification;
        }

        ResponseEntity<?> parentescoVerification = InputVerifier.genericStringInputVerification(
                alunoDTO.getNome(),
                "parentesco",
                99);

        if (parentescoVerification != null) {
            return parentescoVerification;
        }

        return null;
    }
}