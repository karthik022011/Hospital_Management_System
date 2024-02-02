package com.kartheek.hospital.doctor.repository;


import com.kartheek.hospital.doctor.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
