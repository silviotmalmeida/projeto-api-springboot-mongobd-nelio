package com.silviotmalmeida.app.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.silviotmalmeida.app.domain.User;
import com.silviotmalmeida.app.repositories.UserRepository;

// classe de configuração
// será utilizada para database seeding implementando o CommandLineRunner
@Configuration
public class Instantiation implements CommandLineRunner {

    // injetando o repository da entidade User
    @Autowired
    private UserRepository userRepository;

    // método da interface para permitir o database seeding no início da execução
    @Override
    public void run(String... args) throws Exception {

        // limpando a coleção
        userRepository.deleteAll();

        // criando os usuários
        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        // salvando no BD
		userRepository.saveAll(Arrays.asList(maria, alex, bob));
    }
}
