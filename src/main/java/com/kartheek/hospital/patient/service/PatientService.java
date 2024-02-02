package com.kartheek.hospital.patient.service;


import com.kartheek.hospital.patient.model.request.PatientDto;

import java.util.List;

public interface PatientService {
    PatientDto createPatient(PatientDto adminDto);
    PatientDto getPatientById(Long id);
    List<PatientDto> getAllPatients();

}
