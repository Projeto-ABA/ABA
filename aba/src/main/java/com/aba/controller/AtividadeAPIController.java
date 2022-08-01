package com.aba.controller;

import com.aba.dto.AtividadeDTO;
import com.aba.dto.AtividadeDTOCompleto;
import com.aba.dto.AtividadeDTOEditar;
import com.aba.excecoes.AlunoInexistenteException;
import com.aba.interfaces.AtividadeService;
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
        return this.atividadeService.cadastrarAtividade(atividadeDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarAtividade(@PathVariable Long id, @RequestBody AtividadeDTOEditar atividadeDTOEditar) {
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
}
