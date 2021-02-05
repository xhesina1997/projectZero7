package com.example.demo.service;

import com.example.demo.domainModel.UserDTO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDTO> getAllUsers(){
        List<User> users = userRepository.findAll();
        return UserDTO.toDTOs(users);
    }

    public UserDTO getUserById(Long userId){
        Optional<User> user = userRepository.findById(userId);
        return user.map(UserDTO::toDTO).orElse(null);
    }

    public Optional <User> getUserByUsername(String username){
        Optional<User> user = userRepository.findByUsername(username);
        return user;
    }

}
