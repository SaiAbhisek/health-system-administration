package com.abhiproject.hospital.controller;

import com.abhiproject.hospital.model.Doctor;
import com.abhiproject.hospital.service.DoctorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DocterController {

    @Autowired
    private DoctorService doctorService;

    @PostMapping("/doctor")
    public ResponseEntity<Doctor> saveDoctor(@Valid @RequestBody Doctor doctor){
        Doctor doctor1=this.doctorService.saveDoctor(doctor);
        return new ResponseEntity<>(doctor1, HttpStatus.CREATED);
    }

    @PutMapping("/doctor/{id}")
    public ResponseEntity<Doctor> updateDoctor( @PathVariable Integer id,@Valid @RequestBody Doctor doctor){
       Doctor doctor1= this.doctorService.updateDoctor(id,doctor);
       return new ResponseEntity<>(doctor1,HttpStatus.OK);
    }

    @GetMapping("/doctor/{docId}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable  Integer docId)
    {
        Doctor doctor=this.doctorService.getDocById(docId);
        return new ResponseEntity<>(doctor,HttpStatus.OK);
    }

    @GetMapping("/doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors(){
        List<Doctor> doctorList=this.doctorService.getAllDoctors();
        return new ResponseEntity<>(doctorList,HttpStatus.OK);
    }

    @DeleteMapping("/{docId}")
    public ResponseEntity<?> deleteDoc(@PathVariable Integer docId){
        this.doctorService.deleteDoctor(docId);
        return ResponseEntity.ok(Map.of("message","Doctor details are deleted successfully"));
    }

}
