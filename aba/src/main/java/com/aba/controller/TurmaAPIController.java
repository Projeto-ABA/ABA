package com.aba.controller;

import com.aba.dto.TurmaDTO;
import com.aba.dto.TurmasDTO;
import com.aba.service.TurmaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turmas")
public class TurmaAPIController {

    @Autowired
    TurmaServiceImpl turmaService;

    @PostMapping("")
    public ResponseEntity<?> cadastrarTurma(@RequestBody TurmaDTO turmaDTO) {
        return this.turmaService.cadastrarTurma(turmaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarTurma(@PathVariable Long id, @RequestBody TurmaDTO turmaDTO) {
        return this.turmaService.editarTurma(id, turmaDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerTurma(@PathVariable Long id) {
        return this.turmaService.removerTurma(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarTurma(@PathVariable Long id) {
        return this.turmaService.consultarTurma(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarTurmas(){
        return this.turmaService.listarTurmas();
    }

    @PutMapping("/adicionar-aluno/{idTurma}/{idAluno}")
    public ResponseEntity<?> adicionarAlunoEmTurma(@PathVariable Long idTurma, @PathVariable Long idAluno) {
        return this.turmaService.adicionarAlunoEmTurma(idTurma, idAluno);
    }

    @PutMapping("/adicionar-instrutor/{idTurma}/{idInstrutor}")
    public ResponseEntity<?> adicionarInstrutorEmTurma(@PathVariable Long idTurma, @PathVariable Long idInstrutor) {
        return this.turmaService.adicionarInstrutorEmTurma(idTurma, idInstrutor);
    }

    @GetMapping("/listar-alunos/{id}")
    public ResponseEntity<?> listarAlunosDeTurma(@PathVariable Long id){
        return this.turmaService.listarAlunosDeTurma(id);
    }

    @GetMapping("/listar-instrutores/{id}")
    public ResponseEntity<?> listarInstrutoresDeTurma(@PathVariable Long id){
        return this.turmaService.listarInstrutoresDeTurma(id);
    }

    @DeleteMapping("/remover-aluno/{idTurma}/{idAluno}")
    public ResponseEntity<?> removerAlunoDeTurma(@PathVariable Long idTurma, @PathVariable Long idAluno){
        return this.turmaService.removerAlunoDeTurma(idTurma, idAluno);
    }

    @DeleteMapping("/remover-instrutor/{idTurma}/{idInstrutor}")
    public ResponseEntity<?> removerInstrutorDeTurma(@PathVariable Long idTurma, @PathVariable Long idInstrutor) {
        return this.turmaService.removerInstrutorDeTurma(idTurma, idInstrutor);
    }
}