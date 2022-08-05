package com.aba.service;

import com.aba.dto.TurmaDTO;
import com.aba.dto.TurmasDTO;
import com.aba.interfaces.TurmaService;
import com.aba.model.Aluno;
import com.aba.model.Instrutor;
import com.aba.model.Turma;
import com.aba.repository.TurmaRepository;
import com.aba.util.MessageError;
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
        Instrutor instrutor = this.instrutorService.getInstrutorByEmail(turmaDTO.getEmailInstrutor());
        if(instrutor == null){
            return MessageError.erroInstrutorNaoEncontradoByEmail(turmaDTO.getEmailInstrutor());
        }

        Turma turma = new Turma(turmaDTO.getNomeTurma(), turmaDTO.getTurno(), turmaDTO.getDiasDaSemana(), instrutor);
        this.turmaRepository.save(turma);

        return ResponseEntity.status(HttpStatus.CREATED).body(turmaDTO);
    }

    public ResponseEntity<?> editarTurma(Long id, TurmaDTO turmaDTO) {
        Turma turma = this.getTurmaById(id);

        if(turma == null){
            return MessageError.erroTurmaNaoEncontrada(id);
        }

        Instrutor instrutor = this.instrutorService.getInstrutorByEmail(turmaDTO.getEmailInstrutor());
        if(instrutor == null){
            return MessageError.erroInstrutorNaoEncontradoByEmail(turmaDTO.getEmailInstrutor());
        }

        turma.editar(turmaDTO, instrutor);
        this.turmaRepository.save(turma);

        return ResponseEntity.status(HttpStatus.OK).body(turma.getDto());
    }

    public ResponseEntity<?> removerTurma(Long id) {
        Turma turma = this.getTurmaById(id);

        if(turma == null){
            return MessageError.erroTurmaNaoEncontrada(id);
        }

        this.turmaRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Turma removida!");
    }

    public ResponseEntity<?> listarTurmas() {
        List<Turma> turmas = this.turmaRepository.findAll();
        TurmasDTO listaDeTurmasDTO = new TurmasDTO(turmas);

        return ResponseEntity.status(HttpStatus.OK).body(listaDeTurmasDTO.getDadosTurma());
    }

    public ResponseEntity<?> consultarTurma(Long id) {
        Turma turma = this.getTurmaById(id);

        if(turma == null){
            return MessageError.erroTurmaNaoEncontrada(id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(turma.getDto());
    }

    public ResponseEntity<?> adicionarAlunoEmTurma(Long idTurma, Long idAluno) {
        Turma turma = this.getTurmaById(idTurma);

        if(turma == null){
            return MessageError.erroTurmaNaoEncontrada(idTurma);
        }

        Aluno aluno = this.alunoService.getAlunoById(idAluno);

        if(aluno == null){
            return MessageError.erroAlunoNaoEncontrado(idAluno);
        }

        turma.addAluno(aluno);
        this.turmaRepository.save(turma);

        return ResponseEntity.status(HttpStatus.OK).body("Aluno(a) adicionado(a) com sucesso!");
    }

    /**
    public ResponseEntity<?> removerAlunoDeTurma(Long idTurma, Long idAluno){
        Turma turma = this.getTurmaById(idTurma);

        if(turma == null){
            return MessageError.erroTurmaNaoEncontrada(idTurma);
        }

        Aluno aluno = this.alunoService.getAlunoById(idAluno);

        if(aluno == null){
            return MessageError.erroAlunoNaoEncontrado(idAluno);
        }

        turma.removerAluno(aluno);
        this.turmaRepository.save(turma);

        return ResponseEntity.status(HttpStatus.OK).body(turma.listarAlunos());
    }


     public ResponseEntity<?> listarAlunosDeTurma(Long idTurma){
         Turma turma = this.getTurmaById(idTurma);

         if(turma == null){
            return MessageError.erroTurmaNaoEncontrada(idTurma);
         }

         return ResponseEntity.status(HttpStatus.OK).body(turma.listarAlunos());
     }
     **/

    public Turma getTurmaById(Long id){
        Optional<Turma> turmaOptional = this.turmaRepository.findById(id);

        if (!turmaOptional.isPresent()) {
            return null;
        }return turmaOptional.get();
    }

}