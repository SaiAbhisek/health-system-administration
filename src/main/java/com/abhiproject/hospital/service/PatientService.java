package com.abhiproject.hospital.service;

import com.abhiproject.hospital.model.Patient;

import java.util.List;

public interface PatientService {

    Patient savePatient(Patient patient,Integer doctorId);

    Patient updatePatient(Integer id,Patient patient);

    Patient getPatientById(Integer id);

    List<Patient> getAllPatients();

    void deletePatient(Integer id);

    List<Patient> getPatientByDoctor(Integer id);

}
