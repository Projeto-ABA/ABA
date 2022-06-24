package com.aba.interfaces;

import org.springframework.http.ResponseEntity;

import com.aba.dto.AlunoDTO;

public interface AlunoService {
    public ResponseEntity<?> cadastrarAluno(AlunoDTO alunoDTO);

    public ResponseEntity<?> editarAluno(Long id, AlunoDTO alunoDTO);

    public ResponseEntity<?> removerAluno(Long id);

    public ResponseEntity<?> consultarAluno(Long id);

    public ResponseEntity<?> listarAlunos();
}
