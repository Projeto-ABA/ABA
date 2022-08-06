package com.aba.controller;


import com.aba.dto.PlanoObjetivosDTO;
import com.aba.interfaces.PlanoObjetivosService;
import com.aba.util.InputVerifier;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/planoObjetivos")
@Api
public class PlanoObjetivosAPIController {

    @Autowired
    PlanoObjetivosService planoObjetivosService;

    @PostMapping("")
    public ResponseEntity<?> cadastrarPlanoObjetivos(@RequestBody PlanoObjetivosDTO planoObjetivosDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDePlanoObjetivosDTO(planoObjetivosDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.planoObjetivosService.cadastrarPlanoObjetivos(planoObjetivosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarPlanoObjetivos(@PathVariable Long id, @RequestBody PlanoObjetivosDTO planoObjetivosDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDePlanoObjetivosDTO(planoObjetivosDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.planoObjetivosService.editarPlanoObjetivos(id, planoObjetivosDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarPlano(@PathVariable Long id) {
        return this.planoObjetivosService.consultarPlanoObjetivos(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerPlanoObjetivos(@PathVariable Long id) {
        return this.planoObjetivosService.removerPlanoObjetivos(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarPlanos() {
        return this.planoObjetivosService.listarPlanosDeObjetivos();
    }

    @PutMapping("/adicionar-atividade-em-plano/{id}/{idAtividade}")
    public ResponseEntity<?> adicionarAtividadeNoPlano(@PathVariable Long id, @PathVariable Long idAtividade) {
        return this.planoObjetivosService.adicionarAtividadeNoPlano(id, idAtividade);
    }

    @DeleteMapping("/remover-atividade-de-plano/{id}/{idAtividade}")
    public ResponseEntity<?> removerAtividadeDoPlano(@PathVariable Long id, @PathVariable Long idAtividade) {
        return this.planoObjetivosService.removerAtividadeDoPlano(id, idAtividade);
    }

    private ResponseEntity<?> verificacaoGenericaDePlanoObjetivosDTO(PlanoObjetivosDTO planoObjetivosDTO) {

        ResponseEntity<?> nomeDoPlanoVerification = InputVerifier.genericStringInputVerification(
                planoObjetivosDTO.getNomePlano(),
                "nome do plano",
                99);

        if (nomeDoPlanoVerification != null) {
            return nomeDoPlanoVerification;
        }

        ResponseEntity<?> descricaoAlunoVerification = InputVerifier.genericStringInputVerification(
                planoObjetivosDTO.getDescricaoAluno(),
                "descrição aluno",
                99);

        if (descricaoAlunoVerification != null) {
            return descricaoAlunoVerification;
        }

        ResponseEntity<?> emailInstrutorVerification = InputVerifier.genericStringInputVerification(
                planoObjetivosDTO.getEmailInstrutor(),
                "email instrutor",
                99);

        if (emailInstrutorVerification != null) {
            return emailInstrutorVerification;
        }

        return null;
    }
}
