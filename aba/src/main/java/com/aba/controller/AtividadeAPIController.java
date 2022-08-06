package com.aba.controller;

import com.aba.dto.AtividadeDTO;
import com.aba.dto.AtividadeDTOEditar;
import com.aba.interfaces.AtividadeService;
import com.aba.util.InputVerifier;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/atividades")
@Api
public class AtividadeAPIController {

    @Autowired
    AtividadeService atividadeService;

    @PostMapping("")
    public ResponseEntity<?> cadastrarAtividade(@RequestBody AtividadeDTO atividadeDTO) {

        ResponseEntity errorMessage = verificacaoGenericaDeAtividadeDTO(atividadeDTO);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.atividadeService.cadastrarAtividade(atividadeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAtividade(@PathVariable Long id, @RequestBody AtividadeDTOEditar atividadeDTOEditar) {

        ResponseEntity errorMessage = verificacaoGenericaDeAtividadeDTOEditar(atividadeDTOEditar);

        if (errorMessage != null) {
            return errorMessage;
        }

        return this.atividadeService.editarAtividade(id, atividadeDTOEditar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultarAtividade(@PathVariable Long id) {
        return this.atividadeService.consultarAtividade(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removerAtividade(@PathVariable Long id) {
        return this.atividadeService.removerAtividade(id);
    }

    @GetMapping("/listar")
    public ResponseEntity<?> listarAtividades() {
        return this.atividadeService.listarAtividades();
    }

    private ResponseEntity<?> verificacaoGenericaDeAtividadeDTO(AtividadeDTO atividadeDTO) {

        ResponseEntity<?> tituloVerification = InputVerifier.genericStringInputVerification(atividadeDTO.getTitulo(),"titulo", 99);

        if (tituloVerification != null) {
            return tituloVerification;
        }

        ResponseEntity<?> descricaoVerification = InputVerifier.genericStringInputVerification(atividadeDTO.getDescricao(),"descrição", 99);

        if (descricaoVerification != null) {
            return descricaoVerification;
        }

        ResponseEntity<?> emailInstrutorVerification = InputVerifier.genericStringInputVerification(atividadeDTO.getTitulo(),"email instrutor", 99);

        if (emailInstrutorVerification != null) {
            return emailInstrutorVerification;
        }

        return null;
    }

    private ResponseEntity<?> verificacaoGenericaDeAtividadeDTOEditar(AtividadeDTOEditar atividadeDTOEditar) {

        ResponseEntity<?> tituloVerification = InputVerifier.genericStringInputVerification(atividadeDTOEditar.getTitulo(),"titulo", 99);

        if (tituloVerification != null) {
            return tituloVerification;
        }

        ResponseEntity<?> descricaoVerification = InputVerifier.genericStringInputVerification(atividadeDTOEditar.getDescricao(),"descrição", 99);

        if (descricaoVerification != null) {
            return descricaoVerification;
        }

        ResponseEntity<?> emailInstrutorVerification = InputVerifier.genericStringInputVerification(atividadeDTOEditar.getTitulo(),"email instrutor", 99);

        if (emailInstrutorVerification != null) {
            return emailInstrutorVerification;
        }

        ResponseEntity<?> situacaoVerification = InputVerifier.genericStringInputVerification(atividadeDTOEditar.getSituacao(),"situação", 99);

        if (situacaoVerification != null) {
            return situacaoVerification;
        }

        return null;
    }
}
