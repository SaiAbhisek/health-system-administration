package com.abhiproject.hospital.service;

import com.abhiproject.hospital.model.Doctor;

import java.util.List;

public interface DoctorService {

    Doctor saveDoctor(Doctor doctor);

    Doctor updateDoctor(Integer docId,Doctor doctor);

    Doctor getDocById(Integer docId);

    List<Doctor> getAllDoctors();

    void deleteDoctor(Integer docId);
}
