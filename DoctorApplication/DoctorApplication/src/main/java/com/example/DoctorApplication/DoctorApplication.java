package com.example.DoctorApplication;

import com.example.DoctorApplication.dao.DoctorRepository;
import com.example.DoctorApplication.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DoctorApplication implements CommandLineRunner {
//public class DoctorApplication{
    @Autowired
    DoctorRepository doctorRepository;

    public static void main(String[] args) {

        SpringApplication.run(DoctorApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Doctor doctor=new Doctor();
        doctor.setDoctorName("Rahul");
        doctor.setCity("Delhi");
        doctor.setEmail("xyz@gmail.com");
        doctor.setPhoneNumber("9187636544587");
        doctor.setSpeciality("Dentist");
        doctorRepository.save(doctor);

         doctor=new Doctor();
        doctor.setDoctorName("priya");
        doctor.setCity("Ranchi");
        doctor.setEmail("xyz@gmail.com");
        doctor.setPhoneNumber("9187636544587");
        doctor.setSpeciality("Dentist");
        doctorRepository.save(doctor);

        doctor=new Doctor();
        doctor.setDoctorName("Ritesh");
        doctor.setCity("patna");
        doctor.setEmail("xyz@gmail.com");
        doctor.setPhoneNumber("7636544587");
        doctor.setSpeciality("eye specialist");
        doctorRepository.save(doctor);
    }
}
