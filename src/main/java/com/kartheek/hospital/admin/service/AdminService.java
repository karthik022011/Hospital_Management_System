package com.kartheek.hospital.admin.service;

import com.kartheek.hospital.admin.model.request.AdminDto;

import java.util.List;

public interface AdminService {
    AdminDto createAdmin(AdminDto adminDto);
    AdminDto getAdminById(Long id);
    List<AdminDto> getAllAdmins();

}
