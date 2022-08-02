package com.aba.service;
import java.util.List;
import java.util.Optional;

import com.aba.dto.AlunosDTO;
import com.aba.model.Instrutor;
import com.aba.util.exception.CustomerException;
import com.aba.interfaces.InstrutorService;
import com.aba.interfaces.PlanoObjetivosService;
import com.aba.model.PlanoObjetivos;
import com.aba.util.exception.CustomerErro;
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
       Usuario aluno;
       Instrutor instrutor;

        try {
            instrutor = this.instrutorService.getInstrutorByEmail(alunoDTO.getEmailInstrutor());
        } catch (CustomerException e) {
            return CustomerErro.instrutorInexistente(instrutor.getEmail());
        }

        aluno = new Aluno(alunoDTO.getNome(), alunoDTO.getIdade(),
                instrutor, alunoDTO.getContato(), alunoDTO.getGenero(),
                alunoDTO.getCpf(), alunoDTO.getEndereco(),
                alunoDTO.getResponsavel(), alunoDTO.getParentesco());

        alunoRepository.save((Aluno) aluno);
        usuarioRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.CREATED).body(((Aluno) aluno).getDtoCompleto());
    }

    public ResponseEntity<?> editarAluno(Long id, AlunoDTO alunoDTO) {
        Aluno aluno;

        try {
            aluno = this.getAlunoById(id);
        } catch (CustomerException e) {
            return CustomerErro.alunoInexistente(id);
        }
        aluno.editar(alunoDTO, this.instrutorService.getInstrutorByEmail(alunoDTO.getEmailInstrutor()));
        this.alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDtoCompleto());
    }

    public ResponseEntity<?> removerAluno(Long id) {
        try {
            Aluno aluno = this.getAlunoById(id);
        } catch (CustomerException e) {
            return CustomerErro.alunoInexistente(id);
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
        Aluno aluno;
        try {
            aluno = this.getAlunoById(id);
        } catch (CustomerException e) {
            return CustomerErro.alunoInexistente(id);
        }
        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDto());
    }

    public ResponseEntity<?> adicionarPlanoObjetivos(Long id, Long idPlano) throws CustomerException {
        Aluno aluno;
        aluno = getAlunoById(id);
        PlanoObjetivos planoObjetivos;
        planoObjetivos = this.planoObjetivosService.getPlanoObjetivosById(idPlano);

        aluno.addPlanoObjetivo(planoObjetivos);
        this.alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDtoCompleto());
    }

    public ResponseEntity<?> removerPlanoObjetivos(Long id, Long idPlano) throws CustomerException {
        Aluno aluno;
        aluno = getAlunoById(id);
        PlanoObjetivos planoObjetivos;
        planoObjetivos = this.planoObjetivosService.getPlanoObjetivosById(idPlano);

        aluno.removePlanoObjetivo(planoObjetivos);
        this.alunoRepository.save(aluno);

        return ResponseEntity.status(HttpStatus.OK).body(aluno.getDtoCompleto());
    }

    public Aluno getAlunoById(Long id) throws CustomerException {
        Optional<Aluno> alunoOptional = this.alunoRepository.findById(id);

        if (!alunoOptional.isPresent()) {
            throw new CustomerException("O aluno com id mencionado não existe");
        }

        return alunoOptional.get();
    }
}
