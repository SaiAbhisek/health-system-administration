package com.abhiproject.hospital.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer doctorId;

    @NotEmpty
    private String docName;
    private String specialization;
    private Integer experience;

    @NotEmpty
    @Size(min=10,max = 10, message = "please enter a valid number")
    private String phoneNum;


}
