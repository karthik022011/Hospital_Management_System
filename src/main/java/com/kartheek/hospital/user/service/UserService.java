package com.kartheek.hospital.user.service;

import com.kartheek.hospital.user.model.request.UserDto;

import java.util.List;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto getUserById(Long id);
    List<UserDto> getAllUsers();
}
