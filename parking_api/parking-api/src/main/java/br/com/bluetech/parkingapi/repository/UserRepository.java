package br.com.bluetech.parkingapi.repository;

import org.springframework.data.repository.CrudRepository;

import br.com.bluetech.parkingapi.model.UserModel;

public interface UserRepository extends CrudRepository<UserModel, Integer>{ 
}
