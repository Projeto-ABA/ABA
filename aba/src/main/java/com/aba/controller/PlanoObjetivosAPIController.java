package com.aba.controller;


import com.aba.dto.AtividadeDTO;
import com.aba.dto.PlanoObjetivosDTO;
import com.aba.interfaces.PlanoObjetivosService;
import com.aba.model.PlanoObjetivos;
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
        return this.planoObjetivosService.cadastrarPlanoObjetivos(planoObjetivosDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarPlanoObjetivos(@PathVariable Long id, @RequestBody PlanoObjetivosDTO planoObjetivosDTO) {
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
}
