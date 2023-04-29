package com.abhiproject.hospital.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Patient {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer patientId;

    @NotEmpty
    private String patientName;

    @NotNull
    private Integer age;

    private String address;

    @NotEmpty
    @Size(min = 10,max = 10,message = "please provide valid mobile number")
    private String contactNum;

    private String cause;

    @ManyToOne
    @JoinColumn(name = "doc_id")
    private Doctor doctor;
}
