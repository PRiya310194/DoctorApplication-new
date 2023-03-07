package com.example.DoctorApplication.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="tbl_patient")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="patient_id")
    private int patientId;
    @Column(name="patient_name")
    private String patientName;
    @Column(name="patient_city")
    private String patientCity;
    @Column(name="patient_email")
    private String patientEmail;
    @Column(name="patient_phoneNumber")
    private String patientPhoneNumber;
    @Column(name="symptom")
    private String symptom;

}

