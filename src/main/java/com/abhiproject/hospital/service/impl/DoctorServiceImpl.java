package com.abhiproject.hospital.service.impl;

import com.abhiproject.hospital.exception.ResourceNotFoundException;
import com.abhiproject.hospital.model.Doctor;
import com.abhiproject.hospital.repository.DoctorRepo;
import com.abhiproject.hospital.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    @Override
    public Doctor saveDoctor(Doctor doctor) {
        Doctor doc=this.doctorRepo.save(doctor);
        return doc;
    }

    @Override
    public Doctor updateDoctor(Integer docId, Doctor doctor) {
        Doctor doc=this.doctorRepo.findById(docId).orElseThrow(()->new ResourceNotFoundException("Doctor Not Found with the Id you mentioned"));

        doc.setDocName(doctor.getDocName());
        doc.setExperience(doctor.getExperience());
        doc.setPhoneNum(doctor.getPhoneNum());
        doc.setSpecialization(doctor.getSpecialization());

        Doctor updatedDoctor=this.doctorRepo.save(doc);
        return updatedDoctor;
    }

    @Override
    public Doctor getDocById(Integer docId) {
        Doctor doc=this.doctorRepo.findById(docId).orElseThrow(()->new ResourceNotFoundException("Doctor Not Found with the Id you provided"));
        return doc;
    }

    @Override
    public List<Doctor> getAllDoctors() {
        List<Doctor> doctors=this.doctorRepo.findAll();
        return doctors;
    }

    @Override
    public void deleteDoctor(Integer docId) {
        Doctor doc=this.doctorRepo.findById(docId).orElseThrow(()->new ResourceNotFoundException("Doctor not found with the Id you provided"));
        this.doctorRepo.delete(doc);
    }
}
