package com.kartheek.hospital.doctor.controller;


import com.kartheek.hospital.doctor.model.request.DoctorDto;
import com.kartheek.hospital.doctor.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping
    public ResponseEntity<DoctorDto>  createDoctor(@RequestBody DoctorDto doctorDto){
        DoctorDto savedDoctor = doctorService.createDoctor(doctorDto);
        return new ResponseEntity<>(savedDoctor, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<DoctorDto>  getDoctorById(@PathVariable("id") Long adminId){
        DoctorDto doctor = doctorService.getDoctorById(adminId);
        return  ResponseEntity.ok(doctor);

    }

    @GetMapping("/all")
    public ResponseEntity<List<DoctorDto>>  getAllDoctors(@RequestBody DoctorDto adminDto){
        List<DoctorDto> doctors = doctorService.getAllDoctors();
        return ResponseEntity.ok(doctors);
    }
}
