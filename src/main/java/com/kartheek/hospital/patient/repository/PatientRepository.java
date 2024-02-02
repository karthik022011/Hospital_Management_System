package com.kartheek.hospital.patient.repository;


import com.kartheek.hospital.patient.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
