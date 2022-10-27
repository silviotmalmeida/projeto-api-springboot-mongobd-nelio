package com.silviotmalmeida.app.dto;

import java.io.Serializable;
import java.time.Instant;

import com.fasterxml.jackson.annotation.JsonFormat;

// classe utilizada para representar os dados dos comentários
// os comentários não foram considerados como entidade nos regras de negócio, em virtude de sua simplicidade
// é serializable para permitir operações de IO
public class CommentDTO implements Serializable {

    // atributo serial (obrigatório em serializables)
    private static final long serialVersionUID = 1L;

    // declaração dos atributos a serem repassados na requisição
    // definindo o formato ISO8601 como padrão
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT")
    private Instant date;
    private String text;

    // O dados do autor vão estar agregados ao post
    private AuthorDTO author;

    // construtor vazio (necessário para o framework)
    public CommentDTO() {

    }

    // construtor
    public CommentDTO(Instant date, String text, AuthorDTO author) {
        this.date = date;
        this.text = text;
        this.author = author;
    }

    // início dos getters e setters
    // ------------------------------------------------------------------
    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
    // fim dos getters e setters
    // ------------------------------------------------------------------
}