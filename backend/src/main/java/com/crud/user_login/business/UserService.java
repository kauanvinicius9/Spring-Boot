package com.crud.user_login.business;

import org.springframework.stereotype.Service;

@Service 
public class UserService {
    private final UsertRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;

    }

    public void saveUser(User user) {
        repository.saveAndFlush(user);

    }

    public User findUserByEmail(String email) {
        return repository.findByEmail(email).orElseThrow(
            () -> new RuntimeException("E-mail não identificado")
        );
    }

    public void deleteUserByEmail(String email) {
        repository.deleteByEmail(email);
    }

    public void updateUserById(Integer id, User user) {
    User userEntity = repository.findById(id)
            .orElseThrow(() -> new RuntimeException("Usuário não identificado"));

    if (user.getEmail() != null) {
        userEntity.setEmail(user.getEmail());
    }

    if (user.getNome() != null) {
        userEntity.setNome(user.getNome());
    }

    repository.save(userEntity);
    
    }
}