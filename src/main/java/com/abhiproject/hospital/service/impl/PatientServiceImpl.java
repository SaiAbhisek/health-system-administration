package com.abhiproject.hospital.service.impl;

import com.abhiproject.hospital.exception.ResourceNotFoundException;
import com.abhiproject.hospital.model.Doctor;
import com.abhiproject.hospital.model.Patient;
import com.abhiproject.hospital.repository.DoctorRepo;
import com.abhiproject.hospital.repository.PatientRepo;
import com.abhiproject.hospital.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl  implements PatientService{

    @Autowired
    private PatientRepo patientRepo;

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public Patient savePatient(Patient patient,Integer doctorId) {
        Doctor doc=this.doctorRepo.findById(doctorId).orElseThrow(()-> new ResourceNotFoundException("Doctor not found with the id you mentioned"));
        patient.setDoctor(doc);
        Patient patient1=this.patientRepo.save(patient);
        return patient1;
    }

    @Override
    public Patient updatePatient(Integer id, Patient patient) {
        Patient patient1=this.patientRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("patient not found with the id you mentioned"));

        patient1.setPatientName(patient.getPatientName());
        patient1.setAge(patient.getAge());
        patient1.setAddress(patient.getAddress());
        patient1.setCause(patient.getCause());
        if(!(patient.getDoctor()==null)){
            patient1.setDoctor(patient.getDoctor());
        }
        Patient updatedPatient=this.patientRepo.save(patient1);
        return updatedPatient;
    }

    @Override
    public Patient getPatientById(Integer id) {
        Patient patient=this.patientRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("patient not found with the id you provided"));

        return patient;
    }

    @Override
    public List<Patient> getAllPatients() {
        List<Patient> patients=this.patientRepo.findAll();
        return patients;
    }

    @Override
    public void deletePatient(Integer id) {
        Patient patient=this.patientRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("patient not found with the id you provided"));
        this.patientRepo.delete(patient);
    }

    @Override
    public List<Patient> getPatientByDoctor(Integer id) {
        Doctor doctor=this.doctorRepo.findById(id).orElseThrow(()-> new ResourceNotFoundException("doctor not found with the id you mentioned"));
        List<Patient> patients=this.patientRepo.findByDoctor(doctor);
        return patients;
    }
}
