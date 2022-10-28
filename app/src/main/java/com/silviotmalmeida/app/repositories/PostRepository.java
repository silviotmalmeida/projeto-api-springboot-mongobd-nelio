package com.silviotmalmeida.app.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.silviotmalmeida.app.domain.Post;

// classe responsável por executar as operações da entidade User no BD
// as operações básicas já estão implementadas na superclasse MongoRepository
// registrando a classe como repository
@Repository
public interface PostRepository extends MongoRepository<Post, String> {

    // método adicional usando query methods
    // método para buscar um determinado texto nos títulos do post
    List<Post> findByTitleContainingIgnoreCase(String text);

    // método adicional usando linguagem nativa do MongoBD (@Query)
    // método para buscar um determinado texto nos títulos do post
    @Query("{ 'title': { $regex: ?0, $options: 'i' } }")
    List<Post> searchTitle(String text);

    // método adicional usando linguagem nativa do MongoBD (@Query)
    // método para buscar um determinado texto nos títulos, corpo e comentários do
    // post, bem como pela data de publicação
    @Query("{ $and: [ { date: {$gte: ?1} }, { date: {$lte: ?2} }, { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
    List<Post> fullSearch(String text, Date minDate, Date maxDate);
}
