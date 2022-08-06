package com.aba.controller;

import com.aba.dto.TurmaDTO;
import com.aba.interfaces.InstrutorService;
import com.aba.interfaces.TurmaService;
import com.aba.util.InputVerifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/turmas")
public class TurmaAPIController {

    @Autowired
    TurmaService turmaService;

    @Autowired
    InstrutorService instrutorService;

    @PostMapping("")
    public ResponseEntity<?> cadastrarTurma(@RequestBody TurmaDTO turmaDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDeTurmaDTO(turmaDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.turmaService.cadastrarTurma(turmaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarTurma(@PathVariable Long id, @RequestBody TurmaDTO turmaDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDeTurmaDTO(turmaDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

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

    @GetMapping("/listar-alunos/{id}")
    public ResponseEntity<?> listarAlunosDeTurma(@PathVariable Long id){
        return this.turmaService.listarAlunosDeTurma(id);
    }

    @DeleteMapping("/remover-aluno/{idTurma}/{idAluno}")
    public ResponseEntity<?> removerAlunoDeTurma(@PathVariable Long idTurma, @PathVariable Long idAluno){
        return this.turmaService.removerAlunoDeTurma(idTurma, idAluno);
    }

    private ResponseEntity<?> verificacaoGenericaDeTurmaDTO(TurmaDTO turmaDTO) {
        ResponseEntity<?> nomeDaTurmaVerification = InputVerifier.genericStringInputVerification(
                turmaDTO.getNomeTurma(),
                "nome da turma",
                99);

        if (nomeDaTurmaVerification != null) {
            return nomeDaTurmaVerification;
        }

        ResponseEntity<?> turnoVerification = InputVerifier.genericStringInputVerification(
                turmaDTO.getTurno(),
                "turno",
                99);

        if (turnoVerification != null) {
            return turnoVerification;
        }

        ResponseEntity<?> emailInstrutorVerification = InputVerifier.genericStringInputVerification(
                turmaDTO.getEmailInstrutor(),
                "email instrutor",
                99);

        if (emailInstrutorVerification != null) {
            return emailInstrutorVerification;
        }

        ResponseEntity<?> diasDaSemanaVerification = InputVerifier.genericStringInputVerification(
                turmaDTO.getDiasDaSemana(),
                "dias da semana",
                99);

        if (diasDaSemanaVerification != null) {
            return diasDaSemanaVerification;
        }

        return null;
    }
}