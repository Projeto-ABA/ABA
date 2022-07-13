package com.aba.controller;

import com.aba.dto.InstrutorDTO;
import com.aba.interfaces.InstrutorService;
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
        return this.instrutorService.cadastrarInstrutor(instrutorDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarInstrutor(@PathVariable Long id, @RequestBody InstrutorDTO instrutorDTO) {
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
}
