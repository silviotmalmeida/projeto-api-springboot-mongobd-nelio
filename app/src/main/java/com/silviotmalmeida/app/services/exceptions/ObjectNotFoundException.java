package com.silviotmalmeida.app.services.exceptions;

// classe que representa as exceções personalizadas ca camada de serviço
public class ObjectNotFoundException extends RuntimeException {

    // atributo serial
    private static final long serialVersionUID = 1L;

    // criando a exceção para os casos de id não encontrado
    public ObjectNotFoundException(String msg) {
        super(msg);
    }
}
