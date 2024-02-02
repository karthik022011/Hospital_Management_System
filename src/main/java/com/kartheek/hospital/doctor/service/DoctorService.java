package com.kartheek.hospital.doctor.service;


import com.kartheek.hospital.doctor.model.request.DoctorDto;

import java.util.List;

public interface DoctorService {
    DoctorDto createDoctor(DoctorDto adminDto);
    DoctorDto getDoctorById(Long id);
    List<DoctorDto> getAllDoctors();

}
