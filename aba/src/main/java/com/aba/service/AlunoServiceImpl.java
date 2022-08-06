package com.aba.service;
import java.util.List;
import java.util.Optional;

import com.aba.dto.AlunosDTO;
import com.aba.interfaces.InstrutorService;
import com.aba.interfaces.PlanoObjetivosService;
import com.aba.model.Instrutor;
import com.aba.model.PlanoObjetivos;
import com.aba.util.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.aba.dto.AlunoDTO;
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

    @Autowired
    PlanoObjetivosService planoObjetivosService;

    public ResponseEntity<?> cadastrarAluno(AlunoDTO alunoDTO) {
        Instrutor instrutor = this.instrutorService.getInstrutorByEmail(alunoDTO.getEmailInstrutor());
        if(instrutor == null){
            return MessageError.erroInstrutorNaoEncontradoByEmail(alunoDTO.getEmailInstrutor());
        }

        Usuario aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getDataNascimento(), alunoDTO.getCid(),
                instrutor, alunoDTO.getContato(), alunoDTO.getGenero(),
                alunoDTO.getCpf(), alunoDTO.getEndereco(),
                alunoDTO.getResponsavel(), alunoDTO.getParentesco());

        alunoRepository.save((Aluno) aluno);
        usuarioRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(((Aluno) aluno).getDtoCompleto());
    }

    public ResponseEntity<?> editarAluno(Long id, AlunoDTO alunoDTO){
        Aluno aluno = this.getAlunoById(id);
        if(aluno == null){
            return MessageError.erroAlunoNaoEncontrado(id);
        }

        aluno.editar(alunoDTO, this.instrutorService.getInstrutorByEmail(alunoDTO.getEmailInstrutor()));
        this.alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDtoCompleto());
    }

    public ResponseEntity<?> removerAluno(Long id) {
        Aluno aluno = this.getAlunoById(id);
        if(aluno == null){
            return MessageError.erroAlunoNaoEncontrado(id);
        }
        this.usuarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Aluno(a) removido(a)!");
    }

    public ResponseEntity<?> listarAlunos() {
        List<Aluno> alunos = this.alunoRepository.findAll();
        AlunosDTO listaDeAlunos = new AlunosDTO(alunos);

        return ResponseEntity.status(HttpStatus.OK).body(listaDeAlunos.getDadosAlunos());
    }

    public ResponseEntity<?> consultarAluno(Long id) {
        Aluno aluno = this.getAlunoById(id);
        if(aluno == null){
            return MessageError.erroAlunoNaoEncontrado(id);
        }

        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDto());
    }

    public ResponseEntity<?> adicionarPlanoObjetivos(Long id, Long idPlano){
        Aluno aluno = getAlunoById(id);
        if(aluno == null){
            return MessageError.erroAlunoNaoEncontrado(id);
        }

        PlanoObjetivos planoObjetivos = this.planoObjetivosService.getPlanoObjetivosById(idPlano);
        if(planoObjetivos == null){
            return MessageError.erroPlanoNaoEncontrado(idPlano);
        }

        aluno.addPlanoObjetivo(planoObjetivos);
        this.alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDtoCompleto());
    }

    public ResponseEntity<?> removerPlanoObjetivos(Long id, Long idPlano){
        Aluno aluno = getAlunoById(id);
        if(aluno == null){
            return MessageError.erroAlunoNaoEncontrado(id);
        }

        PlanoObjetivos planoObjetivos = this.planoObjetivosService.getPlanoObjetivosById(idPlano);
        if(planoObjetivos == null){
            return MessageError.erroPlanoNaoEncontrado(idPlano);
        }

        aluno.removePlanoObjetivo(planoObjetivos);
        this.alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDtoCompleto());
    }

    public Aluno getAlunoById(Long id){
        Optional<Aluno> alunoOptional = this.alunoRepository.findById(id);

        if (!alunoOptional.isPresent()) {
            return null;
        }return alunoOptional.get();
    }

}
