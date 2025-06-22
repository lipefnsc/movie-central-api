package com.project.moviecentralapi.service;

import com.project.moviecentralapi.model.User;
import com.project.moviecentralapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        // FIXME validar se o username ja existe antes de tentar salvar
        return userRepository.save(user);
    }

    public User findByUsername(String username) {
        // FIXME se nao encontrar o usuario, lançar uma exceção com handler
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException("User not found."));
    }
}
