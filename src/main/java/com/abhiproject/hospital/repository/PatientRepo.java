package com.abhiproject.hospital.repository;

import com.abhiproject.hospital.model.Doctor;
import com.abhiproject.hospital.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepo extends JpaRepository<Patient, Integer> {

    List<Patient> findByDoctor(Doctor doctor);
}
