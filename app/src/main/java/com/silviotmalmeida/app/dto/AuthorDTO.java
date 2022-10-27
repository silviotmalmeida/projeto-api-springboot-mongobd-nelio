package com.silviotmalmeida.app.dto;

import java.io.Serializable;

import com.silviotmalmeida.app.domain.User;

// classe utilizada para filtrar os atributos da coleção a serem retornados na requisição
// é serializable para permitir operações de IO
public class AuthorDTO implements Serializable {

    // atributo serial (obrigatório em serializables)
    private static final long serialVersionUID = 1L;

    // declaração dos atributos a serem repassados na requisição
    private String id;
    private String name;

    // construtor vazio (necessário para o framework)
    public AuthorDTO() {

    }

    // construtor
    public AuthorDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
    }

    // início dos getters e setters
    // ------------------------------------------------------------------
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    // fim dos getters e setters
    // ------------------------------------------------------------------
}