package com.kartheek.hospital.user.service;

import com.kartheek.hospital.user.entity.User;
import com.kartheek.hospital.user.model.request.UserDto;
import com.kartheek.hospital.user.repository.UserRepository;
import com.kartheek.hospital.util.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto adminDto) {
        User admin = modelMapper.map(adminDto, User.class);
        User savedAdmin = userRepository.save(admin);
        return modelMapper.map(savedAdmin, UserDto.class);
    }

    @Override
    public UserDto getUserById(Long id) {
        User admin = userRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Admin not exist with given id: "+ id));
        return modelMapper.map(admin, UserDto.class);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> admins =userRepository.findAll();
        return admins.stream().map((admin) -> modelMapper.map(admin,UserDto.class))
                .collect(Collectors.toList());
    }
}
