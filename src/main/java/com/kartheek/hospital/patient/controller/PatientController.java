package com.kartheek.hospital.patient.controller;


import com.kartheek.hospital.patient.model.request.PatientDto;
import com.kartheek.hospital.patient.service.PatientService;
import com.kartheek.hospital.util.pagination.PagingResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping
    public ResponseEntity<PatientDto>  createPatient(@RequestBody PatientDto patientDto){
        PatientDto savedAdmin = patientService.createPatient(patientDto);
        return new ResponseEntity<>(savedAdmin, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<PatientDto>  getPatientById(@PathVariable("id") Long adminId){
        PatientDto admin = patientService.getPatientById(adminId);
        return  ResponseEntity.ok(admin);
    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientDto>>  getAllPatients(){
        List<PatientDto> admins = patientService.getAllPatients();
        return ResponseEntity.ok(admins);
    }

    //http:localhost:8083//api/v1/patient?pageNo=0&pageSize=5
    @GetMapping()
    public ResponseEntity<PagingResponseDto<PatientDto>>  getPatientsByPagination(
       @RequestParam(defaultValue = "0") Integer pageNo,
       @RequestParam(defaultValue = "10") Integer pageSize){
        PagingResponseDto<PatientDto> patients = patientService.getPatientsByPagination(pageNo, pageSize);
        return ResponseEntity.ok(patients);
    }
}
