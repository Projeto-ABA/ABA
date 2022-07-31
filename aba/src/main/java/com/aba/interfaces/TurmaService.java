package com.aba.interfaces;

import com.aba.dto.TurmaDTO;

import io.swagger.models.Response;
import org.springframework.http.ResponseEntity;

public interface TurmaService {

    public ResponseEntity<?> cadastrarTurma(TurmaDTO turmaDTO);
    public ResponseEntity<?> editarTurma(Long id, TurmaDTO turmaDTO);
    public ResponseEntity<?> removerTurma(Long id);
    public ResponseEntity<?> consultarTurma(Long id);
    public ResponseEntity<?> adicionarAlunoEmTurma(Long idTurma, Long idAluno);
    public ResponseEntity<?> adicionarInstrutorEmTurma(Long idTurma, Long idAluno);
    public ResponseEntity<?> listarAlunosDeTurma(Long idTurma);
    public ResponseEntity<?> listarInstrutoresDeTurma(Long idTurma);
    public ResponseEntity<?> removerAlunoDeTurma(Long idTurma, Long idAluno);
    public ResponseEntity<?> removerInstrutorDeTurma (Long idTurma, Long idInstrutor);

}
