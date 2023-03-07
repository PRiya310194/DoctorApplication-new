package com.example.DoctorApplication.model;


import lombok.*;

import javax.persistence.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

@Table(name="tbl_doctor")
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="doctor_id")
    private int doctorId;
    @Column(name="doctor_name")
    private String doctorName;
    @Column(name="city")
    private String city;
    @Column(name="email")
    private String email;
    @Column(name="phoneNumber")
private String phoneNumber;
    @Column(name="speciality")
    private String speciality;

}
