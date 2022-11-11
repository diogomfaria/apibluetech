package br.com.bluetech.parkingapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.bluetech.parkingapi.model.UserModel;
import br.com.bluetech.parkingapi.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    private UserRepository repository;
    
    @GetMapping(path = "/api/usuario/{id}")
    public ResponseEntity consultar(@PathVariable("id") Integer id) {
        return repository.findById(id)
                .map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/usuario/save")
    public UserModel salvar(@RequestBody UserModel user) {
        return repository.save(user);
    }
}
