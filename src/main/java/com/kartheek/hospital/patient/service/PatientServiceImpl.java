package com.kartheek.hospital.patient.service;



import com.kartheek.hospital.patient.entity.Patient;
import com.kartheek.hospital.patient.model.request.PatientDto;
import com.kartheek.hospital.patient.repository.PatientRepository;
import com.kartheek.hospital.util.exception.ResourceNotFoundException;
import com.kartheek.hospital.util.pagination.PagingResponseDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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

    @Override
    public PagingResponseDto<PatientDto> getPatientsByPagination(int pageNo, int pageSize) {
        //create page request object
        PageRequest pageRequest = PageRequest.of(pageNo,pageSize);
        //pass it to repos
        Page<Patient> pagingUser = patientRepository.findAll(pageRequest);
        List<Patient> patients = pagingUser.getContent();
        List<PatientDto> patientDto = patients.stream().map((patient) -> modelMapper.map(patient,PatientDto.class))
                .toList();
        PagingResponseDto<PatientDto> response = new PagingResponseDto<>(
                patientDto, pagingUser.getNumber(), pagingUser.getSize(),
                pagingUser.getTotalElements(), pagingUser.getTotalPages(), pagingUser.hasNext()
        );
        return response;
    }
}
