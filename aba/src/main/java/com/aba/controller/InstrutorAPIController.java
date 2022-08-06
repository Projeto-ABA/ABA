package com.aba.controller;

import com.aba.dto.InstrutorDTO;
import com.aba.interfaces.InstrutorService;
import com.aba.util.InputVerifier;
import com.aba.util.MessageError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/instrutores")
public class InstrutorAPIController {

    @Autowired
    InstrutorService instrutorService;

    @PostMapping("")
    public ResponseEntity<?> cadastrarInstrutor(@RequestBody InstrutorDTO instrutorDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDeInstrutorDTO(instrutorDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.instrutorService.cadastrarInstrutor(instrutorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarInstrutor(@PathVariable Long id, @RequestBody InstrutorDTO instrutorDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDeInstrutorDTO(instrutorDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.instrutorService.editarInstrutor(id, instrutorDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarInstrutor(@PathVariable Long id){
        return this.instrutorService.consultarInstrutor(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerInstrutor(@PathVariable Long id) {
        return this.instrutorService.removerInstrutor(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarInstrutores(){
        return this.instrutorService.listarInstrutores();
    }

    private ResponseEntity<?> verificacaoGenericaDeInstrutorDTO(InstrutorDTO instrutorDTO) {

        ResponseEntity<?> nomeVerification = InputVerifier.genericStringInputVerification(
            instrutorDTO.getNome(),
            "nome",
            99);

        if (nomeVerification != null) {
            return nomeVerification;
        }

        ResponseEntity<?> sobrenomeVerification = InputVerifier.genericStringInputVerification(
            instrutorDTO.getSobrenome(),
            "sobrenome",
            99);

        if (sobrenomeVerification != null) {
            return sobrenomeVerification;
        }

        ResponseEntity<?> emailVerification = InputVerifier.genericStringInputVerification(
            instrutorDTO.getEmail(),
            "email",
            99);

        if (emailVerification != null) {
            return emailVerification;
        }

        ResponseEntity<?> cpfVerification = InputVerifier.genericStringInputVerification(
                instrutorDTO.getCpf(),
            "cpf",
            99);

        if (cpfVerification != null) {
            return cpfVerification;
        }

        ResponseEntity<?> telefoneVerification = InputVerifier.genericStringInputVerification(
                instrutorDTO.getTelefone(),
            "telefone",
            99);

        if (telefoneVerification != null) {
            return telefoneVerification;
        }

        ResponseEntity<?> instituicaoVerification = InputVerifier.genericStringInputVerification(
            instrutorDTO.getInstituição(),
        "email instrutor",
        99);

        if (instituicaoVerification != null) {
            return instituicaoVerification;
        }

        return null;
    }
}
