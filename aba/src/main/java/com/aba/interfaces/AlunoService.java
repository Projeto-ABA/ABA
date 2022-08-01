package com.aba.interfaces;

import com.aba.excecoes.AlunoInexistenteException;
import org.springframework.http.ResponseEntity;

import com.aba.dto.AlunoDTO;

public interface AlunoService {
    public ResponseEntity<?> cadastrarAluno(AlunoDTO alunoDTO);

    public ResponseEntity<?> editarAluno(Long id, AlunoDTO alunoDTO);

    public ResponseEntity<?> removerAluno(Long id);

    public ResponseEntity<?> consultarAluno(Long id);

    public ResponseEntity<?> listarAlunos();

    public ResponseEntity<?> adicionarPlanoObjetivos(Long id, Long idPlano) throws AlunoInexistenteException;
    public ResponseEntity<?> removerPlanoObjetivos(Long id, Long idPlano) throws AlunoInexistenteException;
}