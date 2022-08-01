package com.aba.service;

import com.aba.dto.InstrutorDTO;
import com.aba.dto.InstrutoresDTO;
import com.aba.interfaces.InstrutorService;
import com.aba.model.Instrutor;
import com.aba.model.Usuario;
import com.aba.repository.InstrutorRepository;
import com.aba.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstrutorServiceImpl implements InstrutorService {

    @Autowired
    InstrutorRepository instrutorRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public ResponseEntity<?> cadastrarInstrutor(InstrutorDTO instrutorDTO) {
        // se eu tentar cadastrar um instrutor com o msm email, não vai dar certo.
        Usuario instrutor;
        instrutor = new Instrutor(instrutorDTO);

        instrutorRepository.save((Instrutor) instrutor);
        usuarioRepository.save(instrutor);

        return ResponseEntity.status(HttpStatus.CREATED).body(instrutorDTO);
    }

    public ResponseEntity<?> editarInstrutor(Long id, InstrutorDTO instrutorDTO) {
        //exeção se o id não existir
        Instrutor instrutor;
        instrutor = this.getInstrutorById(id);
        instrutor.editar(instrutorDTO);
        this.instrutorRepository.save(instrutor);

        return ResponseEntity.status(HttpStatus.OK).body(instrutor.getDtoCompleto());
    }

    public ResponseEntity<?> removerInstrutor(Long id){
        // se eu tentar remover um instrutor com id não existente não deve dar certo.

        this.usuarioRepository.deleteById(id);

        return ResponseEntity.status(HttpStatus.OK).body("Instrutor removido(a)!");
    }

    public ResponseEntity<?> listarInstrutores(){
        List<Instrutor> instrutores = this.instrutorRepository.findAll();
        InstrutoresDTO listaDeInstrutores = new InstrutoresDTO(instrutores);

        return ResponseEntity.status(HttpStatus.OK).body(listaDeInstrutores.getDadosInstrutores());
    }

    public ResponseEntity<?> consultarInstrutor(Long id) {
        // se eu tentar verificar um instrutor com id não existente não deve dar certo

        Instrutor instrutor;
        instrutor = this.getInstrutorById(id);
        return ResponseEntity.status(HttpStatus.OK).body(instrutor.getDto());
    }

    public Instrutor getInstrutorById(Long id){
        Optional<Instrutor> instrutorOptional = this.instrutorRepository.findById(id);

        if (!instrutorOptional.isPresent()) {
            return null;
        }

        return instrutorOptional.get();
    }

    public Instrutor getInstrutorByEmail(String email) {
        Optional<Instrutor> instrutorOptional = this.instrutorRepository.findByEmail(email);

        if(!instrutorOptional.isPresent()) {
            return null;
        } return instrutorOptional.get();
    }
}