package com.kartheek.hospital.patient.service;



import com.kartheek.hospital.patient.entity.Patient;
import com.kartheek.hospital.patient.model.request.PatientDto;
import com.kartheek.hospital.patient.repository.PatientRepository;
import com.kartheek.hospital.util.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public PatientDto createPatient(PatientDto patientDto) {
        Patient patient = modelMapper.map(patientDto, Patient.class);
        Patient savedPatient = patientRepository.save(patient);
        return modelMapper.map(savedPatient, PatientDto.class);
    }

    @Override
    public PatientDto getPatientById(Long id) {
        Patient patient = patientRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Patient not exist with given id: "+ id));
        return modelMapper.map(patient, PatientDto.class);
    }

    @Override
    public List<PatientDto> getAllPatients() {
        List<Patient> patients =patientRepository.findAll();
        return patients.stream().map((admin) -> modelMapper.map(admin,PatientDto.class))
                .collect(Collectors.toList());
    }
}
