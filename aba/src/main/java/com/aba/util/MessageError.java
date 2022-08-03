package com.aba.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class MessageError {

    static final String ALUNO_NAO_CADASTRADO = "O aluno com id %d não está cadastrado no sistema";

    static final String EMAIL_INSTRUTOR_NAO_CADASTRADO = "O instrutor de email %s não está cadastrado no sistema";

    static final String ID_INSTRUTOR_NAO_ENCONTRADO = "O instrutor de id %d não está cadastrado no sistema";

    static final String EMAIL_INSTRUTOR_JA_CADASTRADO = "Um instrutor com email %s já está cadastrado no sistema";

    static final String ATIVIDADE_NAO_CADASTRADA = "A atividade com id %d não está cadastrada no sistema";

    static final String PLANO_NAO_CADASTRADO = "A plano de objetivos com id %d não está cadastrado no sistema";

    static final String TURMA_NAO_CADASTRADA = "A turma com id %d não está cadastrada no sistema";

    public static ResponseEntity<?> erroAlunoNaoEncontrado(long id){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(MessageError.ALUNO_NAO_CADASTRADO, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> erroInstrutorNaoEncontradoByEmail(String email) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(MessageError.EMAIL_INSTRUTOR_NAO_CADASTRADO, email)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> erroInstrutorNaoEncontradoById(Long id) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(MessageError.ID_INSTRUTOR_NAO_ENCONTRADO, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> erroEmailInstrutorJaCadastrado(String email) {
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(MessageError.EMAIL_INSTRUTOR_JA_CADASTRADO, email)),
                HttpStatus.CONFLICT);
    }

    public static ResponseEntity<?> erroAtividadeNaoEncontrada(long id){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(MessageError.ATIVIDADE_NAO_CADASTRADA, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> erroPlanoNaoEncontrado(long id){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(MessageError.PLANO_NAO_CADASTRADO, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> erroTurmaNaoEncontrada(long id){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(MessageError.TURMA_NAO_CADASTRADA, id)),
                HttpStatus.NOT_FOUND);
    }

}
