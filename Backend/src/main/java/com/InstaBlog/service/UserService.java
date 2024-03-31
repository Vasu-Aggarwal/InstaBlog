package com.InstaBlog.service;

import com.InstaBlog.payload.UserDto;
import jakarta.persistence.Id;

import java.util.List;

public interface UserService {

    UserDto registerNewUser(UserDto user);
    UserDto createUser(UserDto userdto);
    UserDto updateUser(UserDto userDto, Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userId);
}
