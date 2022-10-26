package com.silviotmalmeida.app.dto;

import java.io.Serializable;

import com.silviotmalmeida.app.domain.User;

// classe utilizada para filtrar os atributos da coleção a serem retornados na requisição
// é serializable para permitir operações de IO
public class UserDTO implements Serializable {

    // atributo serial (obrigatório em serializables)
    private static final long serialVersionUID = 1L;

    // declaração dos atributos a serem repassados na requisição
    // não realizamos nenhum filtro neste caso
    private String id;
    private String name;
    private String email;

    // construtor vazio (necessário para o framework)
    public UserDTO() {

    }

    // construtor
    public UserDTO(User obj) {
        this.id = obj.getId();
        this.name = obj.getName();
        this.email = obj.getEmail();
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    // fim dos getters e setters
    // ------------------------------------------------------------------
}