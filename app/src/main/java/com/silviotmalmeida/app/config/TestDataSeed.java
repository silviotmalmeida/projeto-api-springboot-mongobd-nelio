package com.silviotmalmeida.app.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.silviotmalmeida.app.domain.Post;
import com.silviotmalmeida.app.domain.User;
import com.silviotmalmeida.app.dto.AuthorDTO;
import com.silviotmalmeida.app.dto.CommentDTO;
import com.silviotmalmeida.app.repositories.PostRepository;
import com.silviotmalmeida.app.repositories.UserRepository;

// classe de configuração
// será utilizada para database seeding implementando o CommandLineRunner
@Configuration
public class TestDataSeed implements CommandLineRunner {

    // injetando o repository da entidade User
    @Autowired
    private UserRepository userRepository;

    // injetando o repository da entidade Post
    @Autowired
    private PostRepository postRepository;

    // método da interface para permitir o database seeding no início da execução
    @Override
    public void run(String... args) throws Exception {

        // limpando as coleções
        userRepository.deleteAll();
        postRepository.deleteAll();

        // criando os usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        // salvando no BD
        userRepository.saveAll(Arrays.asList(maria, alex, bob));

        // criando os posts
        Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
                new AuthorDTO(maria));
        Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));

        // salvando no BD
        postRepository.saveAll(Arrays.asList(post1, post2));

        // atualizando os posts dos usuários
        maria.getPosts().addAll(Arrays.asList(post1, post2));

        // salvando no BD
        userRepository.save(maria);

        // criando os comentários
        CommentDTO c1 = new CommentDTO(Instant.now(), "Boa viagem mano!", new AuthorDTO(alex));
        CommentDTO c2 = new CommentDTO(Instant.now(), "Aproveite!", new AuthorDTO(bob));
        CommentDTO c3 = new CommentDTO(Instant.now(), "Tenha um ótimo dia!", new AuthorDTO(alex));

        // atualizando os comentários dos posts
        post1.getComments().addAll(Arrays.asList(c1, c2));
        post2.getComments().addAll(Arrays.asList(c3));

        // salvando no BD
        postRepository.saveAll(Arrays.asList(post1, post2));
    }
}
