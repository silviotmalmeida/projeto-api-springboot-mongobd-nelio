package com.silviotmalmeida.app.resources;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.silviotmalmeida.app.domain.Post;
import com.silviotmalmeida.app.resources.utils.URL;
import com.silviotmalmeida.app.services.PostService;

// classe que implementa o controller da entidade Post
// implementa o endpoint "/posts"
@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    // injetando o service da entidade Post
    @Autowired
    private PostService service;

    // método que retorna todos os registros
    // acessível via método GET
    @GetMapping
    public ResponseEntity<List<Post>> findAll() {

        // obtendo a lista de registros
        List<Post> list = this.service.findAll();

        // retorna a resposta com status 200 e registros no body
        return ResponseEntity.ok().body(list);
    }

    // método que retorna o registro do id selecionado
    // acessível via método GET, adicionando o parâmetro /id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Post> findById(@PathVariable String id) {

        // obtendo o registro
        Post obj = this.service.findById(id);

        // retorna a resposta com status 200 e registros no body
        return ResponseEntity.ok().body(obj);
    }

    // método que retorna os registros cujo título corresponda ao texto da busca
    // acessível via método GET, adicionando o parâmetro /titlesearch?text=
    @GetMapping(value = "/titlesearch")
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {

        // decodificando o parâmetro recebido
        text = URL.decodeParam(text);

        // obtendo os registros
        List<Post> list = this.service.findByTitle(text);

        // retorna a resposta com status 200 e registros no body
        return ResponseEntity.ok().body(list);
    }

    // método que retorna os posts que contém o texto de busca no título, corpo ou
    // comentários, bem como pela data de publicação
    // acessível via método GET, adicionando o parâmetro /fullsearch?text=&mindate=&maxdate=
    @GetMapping(value = "/fullsearch")
    public ResponseEntity<List<Post>> fullSearch(
            @RequestParam(value = "text", defaultValue = "") String text,
            @RequestParam(value = "mindate", defaultValue = "") String minDate,
            @RequestParam(value = "maxdate", defaultValue = "") String maxDate) {

        // decodificando o parâmetro recebido
        text = URL.decodeParam(text);

        // convertendo as datas recebidas
        //caso a conversão apresente falha, retorna a data 0
        Date min = URL.convertDate(minDate, new Date(0L));

        //caso a conversão apresente falha, retorna a data atual
        Date max = URL.convertDate(maxDate, new Date());

        // obtendo os registros
        List<Post> list = this.service.fullSearch(text, min, max);

        // retorna a resposta com status 200 e registros no body
        return ResponseEntity.ok().body(list);
    }
}
