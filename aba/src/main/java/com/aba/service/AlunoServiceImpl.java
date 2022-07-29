package com.aba.service;

import java.util.List;
import java.util.Optional;

import aj.org.objectweb.asm.Opcodes;
import com.aba.excecoes.AlunoInexistenteException;
import com.aba.interfaces.InstrutorService;
import com.aba.interfaces.TurmaService;
import com.aba.model.Turma;
import com.aba.repository.TurmaRepository;
import com.aba.util.erros.ErroUsuario;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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

    @Lazy
    TurmaService turmaService;

    public ResponseEntity<?> cadastrarAluno(AlunoDTO alunoDTO) {
        Usuario aluno;
        aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getIdade(), turmaService.getTurmaByNome(alunoDTO.getTurma()), instrutorService.getInstrutorByEmail(alunoDTO.getInstrutorEmail()));

        alunoRepository.save((Aluno) aluno);
        usuarioRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoDTO);
    }

    public ResponseEntity<?> editarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno;
        try {
            aluno = this.getAlunoById(id);
        } catch (AlunoInexistenteException e) {
            return ErroUsuario.alunoInexistente(id);
        }
        aluno.editar(alunoDTO.getNome(), alunoDTO.getIdade(), turmaService.getTurmaByNome(alunoDTO.getTurma()), instrutorService.getInstrutorByEmail(alunoDTO.getInstrutorEmail()));
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
        try {
            aluno = this.getAlunoById(id);
        } catch (AlunoInexistenteException e) {
            return ErroUsuario.alunoInexistente(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDto());
    }

    public Aluno getAlunoById(Long id) throws AlunoInexistenteException {
        Optional<Aluno> alunoOptional = this.alunoRepository.findById(id);

        if (!alunoOptional.isPresent()) {
            throw new AlunoInexistenteException("O aluno com id mencionado não existe");
        }

        return alunoOptional.get();
    }
}
