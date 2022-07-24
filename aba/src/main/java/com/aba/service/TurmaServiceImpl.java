package com.aba.service;

import com.aba.dto.TurmaDTO;
import com.aba.dto.TurmasDTO;
import com.aba.interfaces.TurmaService;
import com.aba.model.Aluno;
import com.aba.model.Instrutor;
import com.aba.model.Turma;
import com.aba.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TurmaServiceImpl implements TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    @Autowired
    AlunoServiceImpl alunoService;

    @Autowired
    InstrutorServiceImpl instrutorService;

    public ResponseEntity<?> cadastrarTurma(TurmaDTO turmaDTO) {
        Turma turma;
        turma = new Turma(turmaDTO);

        this.turmaRepository.save(turma);

        ResponseEntity.status(HttpStatus.CREATED).body(turmaDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaDTO);
    }

    public ResponseEntity<?> editarTurma(Long id, TurmaDTO turmaDTO) {
        Turma turma;
        turma = this.getTurmaById(id);
        turma.setNome(turmaDTO.getNomeTurma());

        this.turmaRepository.save(turma);
        return ResponseEntity.status(HttpStatus.OK).body(turma.getDto());
    }

    public ResponseEntity<?> removerTurma(Long id) {
        this.turmaRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Turma removida!");
    }

    public ResponseEntity<?> listarTurmas() {
        List<Turma> turmas = this.turmaRepository.findAll();
        TurmasDTO listaDeTurmasDTO = new TurmasDTO(turmas);

        return ResponseEntity.status(HttpStatus.OK).body(listaDeTurmasDTO.getDadosTurma());
    }

    public ResponseEntity<?> consultarTurma(Long id) {
        Turma turma;
        turma = this.getTurmaById(id);
        return ResponseEntity.status(HttpStatus.OK).body(turma.getDto());
    }

    public ResponseEntity<?> adicionarAlunoEmTurma(Long idTurma, Long idAluno) {
        Turma turma;
        Aluno aluno;

        turma = this.getTurmaById(idTurma);
        aluno = this.alunoService.getAlunoById(idAluno);

        turma.adicionarAluno(aluno);
        this.turmaRepository.save(turma);

        return ResponseEntity.status(HttpStatus.OK).body(turma.listarAlunos());
    }

    public ResponseEntity<?> adicionarInstrutorEmTurma(Long idTurma, Long idInstrutor) {
        Turma turma;
        Instrutor instrutor;

        turma = this.getTurmaById(idTurma);
        instrutor = this.instrutorService.getInstrutorById(idInstrutor);

        turma.adicionarInstrutor(instrutor);
        this.turmaRepository.save(turma);

        return ResponseEntity.status(HttpStatus.OK).body(turma.listarInstrutores());
    }

    public ResponseEntity<?> listarAlunosDeTurma(Long idTurma){
        Turma turma;
        turma = this.getTurmaById(idTurma);

        return ResponseEntity.status(HttpStatus.OK).body(turma.listarAlunos());
    }

    public ResponseEntity<?> listarInstrutoresDeTurma(Long idTurma){
        Turma turma;
        turma = this.getTurmaById(idTurma);

        return ResponseEntity.status(HttpStatus.OK).body(turma.listarInstrutores());
    }

    public ResponseEntity<?> removerAlunoDeTurma(Long idTurma, Long idAluno) {
        Turma turma;
        Aluno aluno;

        turma = this.getTurmaById(idTurma);
        aluno = this.alunoService.getAlunoById(idAluno);

        turma.removerAluno(aluno);
        this.turmaRepository.save(turma);

        return ResponseEntity.status(HttpStatus.OK).body(turma.listarAlunos());
    }

    public ResponseEntity<?> removerInstrutorDeTurma(Long idTurma, Long idInstrutor) {
        Turma turma;
        Instrutor instrutor;

        turma = this.getTurmaById(idTurma);
        instrutor = this.instrutorService.getInstrutorById(idInstrutor);

        turma.removerInstrutor(instrutor);
        this.turmaRepository.save(turma);

        return ResponseEntity.status(HttpStatus.OK).body(turma.listarInstrutores());
    }

    public Turma getTurmaById(Long id){
        Optional<Turma> turmaOptional = this.turmaRepository.findById(id);

        if (!turmaOptional.isPresent()) {
            return null;
        }

        return turmaOptional.get();
    }
}
