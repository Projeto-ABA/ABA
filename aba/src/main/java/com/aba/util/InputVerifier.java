package com.aba.util;

import org.springframework.http.ResponseEntity;

public class InputVerifier {

    public static ResponseEntity<?> genericStringInputVerification (String input, String campo, int maxLength) {
        if (input == null) {
            return MessageError.erroCampoNulo(campo);

        } else if (input.length() > maxLength) {
            return MessageError.erroCampoMuitoLongo(campo, maxLength);

        } else if (input.equals("")) {
            return MessageError.erroCampoVazio(campo);
        }

        return null;
    }
}
