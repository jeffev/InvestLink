package com.bezkoder.spring.jpa.postgresql.resources;

public class UsuarioExistenteException extends RuntimeException {

    public UsuarioExistenteException(String mensagem) {
        super(mensagem);
    }
}
