package com.abhiproject.hospital.controller;

import com.abhiproject.hospital.model.Patient;
import com.abhiproject.hospital.service.PatientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/doctor/{doctorId}/patient")
    public ResponseEntity<Patient> savePatient(@Valid @RequestBody Patient patient,
                                               @PathVariable Integer doctorId){
        Patient patient1=this.patientService.savePatient(patient,doctorId);
        return new ResponseEntity<>(patient1, HttpStatus.CREATED);
    }

    @GetMapping("/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Integer id){
        Patient patient=this.patientService.getPatientById(id);
        return new ResponseEntity<>(patient,HttpStatus.OK);
    }

    @GetMapping("/patients")
    public ResponseEntity<List<Patient>> getAllPatients()
    {
        List<Patient> patients=this.patientService.getAllPatients();
        return new ResponseEntity<>(patients,HttpStatus.OK);
    }

    @DeleteMapping("/patient/{id}")
    public ResponseEntity<?> deletePatient(@PathVariable Integer id){
        this.patientService.deletePatient(id);
        return ResponseEntity.ok(Map.of("message","patient details deleted successfully"));
    }

    @PutMapping("/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@Valid @RequestBody  Patient patient,@PathVariable Integer id){
        Patient patient1=this.patientService.updatePatient(id,patient);
        return new ResponseEntity<>(patient1,HttpStatus.OK);
    }

    @GetMapping("/patients/doctorid/{id}")
    public ResponseEntity<List<Patient>> getPatientByDoctor(@PathVariable Integer id){
        List<Patient> patients=this.patientService.getPatientByDoctor(id);
        return new ResponseEntity<>(patients,HttpStatus.OK);
    }
}
