package com.kartheek.hospital.admin.service;

import com.kartheek.hospital.admin.entity.Admin;
import com.kartheek.hospital.admin.model.request.AdminDto;
import com.kartheek.hospital.admin.repository.AdminRepository;
import com.kartheek.hospital.util.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AdminDto createAdmin(AdminDto adminDto) {
        Admin admin = modelMapper.map(adminDto, Admin.class);
        Admin savedAdmin = adminRepository.save(admin);
        return modelMapper.map(savedAdmin, AdminDto.class);
    }

    @Override
    public AdminDto getAdminById(Long id) {
        Admin admin = adminRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Admin not exist with given id: "+ id));
        return modelMapper.map(admin, AdminDto.class);
    }

    @Override
    public List<AdminDto> getAllAdmins() {
        List<Admin> admins =adminRepository.findAll();
        return admins.stream().map((admin) -> modelMapper.map(admin,AdminDto.class))
                .collect(Collectors.toList());
    }
}
