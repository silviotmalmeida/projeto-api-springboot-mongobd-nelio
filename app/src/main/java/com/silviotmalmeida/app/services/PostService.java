package com.silviotmalmeida.app.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silviotmalmeida.app.domain.Post;
import com.silviotmalmeida.app.repositories.PostRepository;
import com.silviotmalmeida.app.services.exceptions.ObjectNotFoundException;

// classe de serviço que realiza a comunicação entre o PostResource e o PostRepository
// registrando a classe como service
@Service
public class PostService {

	// injetando o repository da entidade Post
	@Autowired
	private PostRepository repository;

	// método que retorna todos os registros
	public List<Post> findAll() {
		return this.repository.findAll();
	}

	// método que retorna o registro do id selecionado
	public Post findById(String id) {

		// obtendo o registro
		Optional<Post> obj = this.repository.findById(id);

		// se existir, retorna o registro, senão lança uma exceção personalizada
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	// método que retorna os posts que contém o texto de busca no título
	public List<Post> findByTitle(String text) {

		// obtendo os registros
		// utilizando query methods
		// return this.repository.findByTitleContainingIgnoreCase(text);

		// utilizando @Query
		return this.repository.searchTitle(text);
	}

	// método que retorna os posts que contém o texto de busca no título, corpo ou
	// comentários, bem como pela data de publicação
	public List<Post> fullSearch(String text, Date minDate, Date maxDate) {

		// ajustando a data para considerar registros até o final do dia
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);

		// obtendo os registros
		// utilizando @Query
		return this.repository.fullSearch(text, minDate, maxDate);
	}
}
