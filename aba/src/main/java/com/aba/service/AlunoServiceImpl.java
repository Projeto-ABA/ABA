package com.aba.service;

import java.util.List;
import java.util.Optional;

import com.aba.interfaces.InstrutorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aba.dto.AlunoDTO;
import com.aba.dto.AlunosDTO;
import com.aba.interfaces.AlunoService;
import com.aba.model.Aluno;
import com.aba.model.Usuario;
import com.aba.repository.AlunoRepository;
import com.aba.repository.UsuarioRepository;

@Service
public class AlunoServiceImpl implements AlunoService {
    
    @Autowired
    AlunoRepository alunoRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    InstrutorService instrutorService;

    public ResponseEntity<?> cadastrarAluno(AlunoDTO alunoDTO) {
        Usuario aluno;
        aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getIdade(), alunoDTO.getTurma(), instrutorService.getInstrutorByEmail(alunoDTO.getInstrutorEmail()));

        alunoRepository.save((Aluno) aluno);
        usuarioRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
    }

    public ResponseEntity<?> editarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno;
        aluno = this.getAlunoById(id);
        aluno.editar(alunoDTO.getNome(), alunoDTO.getIdade(), alunoDTO.getTurma(), instrutorService.getInstrutorByEmail(alunoDTO.getInstrutorEmail()));
        this.alunoRepository.save(aluno);
        
        return ResponseEntity.status(HttpStatus.OK).body(aluno.getTotalDto());
    }

    public ResponseEntity<?> removerAluno(Long id) {
        this.usuarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Aluno(a) removido(a)!");
    }

    public ResponseEntity<?> listarAlunos() {
        List<Aluno> alunos = this.alunoRepository.findAll();
        AlunosDTO listaDeAlunos = new AlunosDTO(alunos);
        
        return ResponseEntity.status(HttpStatus.OK).body(listaDeAlunos.getDadosAlunos());
    }

    public ResponseEntity<?> consultarAluno(Long id) {
        Aluno aluno;
        aluno = this.getAlunoById(id);
        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDto());
    }

    public Aluno getAlunoById(Long id) {
        Optional<Aluno> alunoOptional = this.alunoRepository.findById(id);

        if (!alunoOptional.isPresent()) {
            return null;
        } //criar excecao futuramente

        return alunoOptional.get();
    }
}
