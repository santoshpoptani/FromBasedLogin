package com.example.loginsystem.services;

import com.example.loginsystem.Dto.UserDto;
import com.example.loginsystem.Entities.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
