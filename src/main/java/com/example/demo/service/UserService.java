package com.example.demo.service;

import com.example.demo.domainModel.UserDTO;
import com.example.demo.entity.UserData;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        List<UserData> users = userRepository.findAll();
        return UserDTO.toDTOs(users);
    }

    public UserDTO getUserById(Long userId){
        Optional<UserData> user = userRepository.findById(userId);
        return user.map(UserDTO::toDTO).orElse(null);
    }

    public Optional <UserData> getUserByUsername(String username){
        Optional<UserData> user = userRepository.findByUsername(username);
        return user;
    }

}
