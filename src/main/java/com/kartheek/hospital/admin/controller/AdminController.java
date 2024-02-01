package com.kartheek.hospital.admin.controller;

import com.kartheek.hospital.admin.model.request.AdminDto;
import com.kartheek.hospital.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping
    public ResponseEntity<AdminDto>  createAdmin(@RequestBody AdminDto adminDto){
        AdminDto savedAdmin = adminService.createAdmin(adminDto);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<AdminDto>  getAdminById(@PathVariable("id") Long adminId){
        AdminDto admin = adminService.getAdminById(adminId);
        return  ResponseEntity.ok(admin);

    }

    @GetMapping("/all")
    public ResponseEntity<List<AdminDto>>  getAllAdmins(@RequestBody AdminDto adminDto){
        List<AdminDto> admins = adminService.getAllAdmins();
        return ResponseEntity.ok(admins);
    }
}
