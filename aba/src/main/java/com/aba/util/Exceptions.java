package com.aba.util;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
public class Exceptions {

    static final String ALUNO_NAO_CADASTRADO = "O aluno de id %d não está cadastrado no sistema";

    static final String TURMA_NAO_CADASTRADA = "A turma de id %d não está cadastrada no sistema";

    static final String INSTRUTOR_NAO_CADASTRADO = "O instrutor de id %d não está cadastrado no sistema";

    public static ResponseEntity<?> erroAlunoNaoEncontrado(long id){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(Exceptions.ALUNO_NAO_CADASTRADO, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> erroTurmaNaoEncontrada(long id){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(Exceptions.TURMA_NAO_CADASTRADA, id)),
                HttpStatus.NOT_FOUND);
    }

    public static ResponseEntity<?> erroInstrutorNaoEncontrado(long id){
        return new ResponseEntity<CustomErrorType>(new CustomErrorType(String.format(Exceptions.INSTRUTOR_NAO_CADASTRADO, id)),
                HttpStatus.NOT_FOUND);
    }

}
