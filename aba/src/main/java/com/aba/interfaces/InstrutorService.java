package com.aba.interfaces;
import com.aba.dto.InstrutorDTO;
import com.aba.model.Instrutor;
import org.springframework.http.ResponseEntity;

public interface InstrutorService {

    public ResponseEntity<?> cadastrarInstrutor(InstrutorDTO instrutorDTO);

    public ResponseEntity<?> editarInstrutor(Long id, InstrutorDTO instrutorDTO);

    public ResponseEntity<?> removerInstrutor(Long id);

    public ResponseEntity<?> consultarInstrutor(Long id);

    public ResponseEntity<?> listarInstrutores();

    public Instrutor getInstrutorById(Long id);
}