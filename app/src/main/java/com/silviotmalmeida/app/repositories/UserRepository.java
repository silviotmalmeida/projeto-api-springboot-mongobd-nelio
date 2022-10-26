package com.silviotmalmeida.app.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.silviotmalmeida.app.domain.User;

// classe responsável por executar as operações da entidade User no BD
// as operações básicas já estão implementadas na superclasse MongoRepository
// registrando a classe como repository
@Repository
public interface UserRepository extends MongoRepository<User, String> {
    
}
