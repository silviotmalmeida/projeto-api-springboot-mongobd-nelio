package com.silviotmalmeida.app.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

// classe que representa uma entidade User
// é serializable para permitir operações de IO
// foi incluída a anotação de identificação como documento do mongodb
// foi incluída a anotação para mapeamento da coleção cl_user
@Document(collection = "cl_user")
public class User implements Serializable {

    // atributo serial (obrigatório em serializables)
    private static final long serialVersionUID = 1L;

    // declaração dos atributos
    // definindo o id como chave primária gerada automaticamente
    @Id
    private String id;

    private String name;
    private String email;

    // o usuário deve conter a lista dos posts de sua autoria
    // definindo como referência de uma nova coleção
    // o atributo lazy = true desativa o carregamento automático dos posts na
    // listagem de usuários, só sendo carregados através do getPosts()
    @DBRef(lazy = true)
    private List<Post> posts = new ArrayList<>();

    // construtor vazio (necessário para o framework)
    public User() {

    }

    // construtor
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
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

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
    // fim dos getters e setters
    // ------------------------------------------------------------------

    // hashcode e equals para permitir comparação de objetos
    // ------------------------------------------------------------------
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        User other = (User) obj;
        return Objects.equals(id, other.id);
    }
    // ------------------------------------------------------------------
}
