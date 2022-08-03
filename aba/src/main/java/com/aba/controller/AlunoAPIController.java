package com.aba.controller;

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
        return this.alunoService.cadastrarAluno(alunoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAluno(@PathVariable Long id, @RequestBody AlunoDTO alunoDTO){
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
}