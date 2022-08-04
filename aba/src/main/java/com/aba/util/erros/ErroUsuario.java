package com.aba.util.erros;

import com.aba.dto.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.aba.util.Constantes.ALUNO_INEXISTENTE;

public class ErroUsuario {
    public static ResponseEntity<?> alunoInexistente(Long id) {
        Response response = new Response(HttpStatus.NOT_FOUND.value(), String.format(ALUNO_INEXISTENTE, id));
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
}
