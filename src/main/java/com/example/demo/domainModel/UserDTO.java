package com.example.demo.domainModel;

import com.example.demo.entity.UserData;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


@Data
public class UserDTO {

    private Long id;

    private String username;

    private String name;

    private String address;

    public static UserDTO toDTO(UserData user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setUsername(user.getUsername());
        userDTO.setAddress(user.getAddress());
        userDTO.setName(user.getName());
        return userDTO;
    }
    public static List<UserDTO> toDTOs(List<UserData> users){
        return users.stream().map(UserDTO::toDTO).collect(Collectors.toList());
    }

}
