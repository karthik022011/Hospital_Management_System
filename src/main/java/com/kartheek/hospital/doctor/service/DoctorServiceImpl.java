package com.kartheek.hospital.doctor.service;


import com.kartheek.hospital.doctor.entity.Doctor;
import com.kartheek.hospital.doctor.model.request.DoctorDto;
import com.kartheek.hospital.doctor.repository.DoctorRepository;
import com.kartheek.hospital.util.exception.ResourceNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public DoctorDto createDoctor(DoctorDto doctorDto) {
        Doctor doctor = modelMapper.map(doctorDto, Doctor.class);
        Doctor savedDoctor = doctorRepository.save(doctor);
        return modelMapper.map(savedDoctor, DoctorDto.class);
    }

    @Override
    public DoctorDto getDoctorById(Long id) {
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Admin not exist with given id: "+ id));
        return modelMapper.map(doctor, DoctorDto.class);
    }

    @Override
    public List<DoctorDto> getAllDoctors() {
        List<Doctor> admins =doctorRepository.findAll();
        return admins.stream().map((admin) -> modelMapper.map(admin,DoctorDto.class))
                .collect(Collectors.toList());
    }
}
