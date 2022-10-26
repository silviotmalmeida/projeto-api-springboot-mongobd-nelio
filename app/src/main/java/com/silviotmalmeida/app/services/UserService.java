package com.silviotmalmeida.app.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.silviotmalmeida.app.domain.User;
import com.silviotmalmeida.app.dto.UserDTO;
import com.silviotmalmeida.app.repositories.UserRepository;
import com.silviotmalmeida.app.services.exceptions.ObjectNotFoundException;

// classe de serviço que realiza a comunicação entre o UserResource e o UserRepository
// registrando a classe como service
@Service
public class UserService {

	// injetando o repository da entidade User
	@Autowired
	private UserRepository repository;

	// método que retorna todos os registros
	public List<User> findAll() {
		return this.repository.findAll();
	}

	// método que retorna o registro do id selecionado
	public User findById(String id) {

		// obtendo o registro
		Optional<User> obj = this.repository.findById(id);

		// se existir, retorna o registro, senão lança uma exceção personalizada
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	// método que insere um registro no BD
	public User insert(User obj) {

		// retorna o registro, após a inserção
		return this.repository.save(obj);
	}

	// método que remove um registro no BD
	public void delete(String id) {

		// verificando se o objeto existe
		this.findById(id);

		// se existir, remove
		this.repository.deleteById(id);
	}

	// método que edita um registro no BD
	public User update(String id, User obj) {

		// obtendo os dados contidos no BD
		User entity = this.findById(id);

		// editando os atributos permitidos
		updateData(entity, obj);

		// retorna o registro, após a edição
		return this.repository.save(entity);
	}

	// método auxiliar para realizar a edição de atributos permitidos de um
	// registro
	private void updateData(User entity, User obj) {

		// editando os atributos permitidos		
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
	}

	// método que instancia um User a partir de um UserDTO
	public User fromDTO(UserDTO objDto) {

		return new User(objDto.getId(), objDto.getName(), objDto.getEmail());
	}
}
