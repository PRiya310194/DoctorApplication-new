package com.example.DoctorApplication.controller;

import com.example.DoctorApplication.model.Doctor;
import com.example.DoctorApplication.service.DoctorService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController

public class DoctorController {
    @Autowired
    DoctorService doctorservice;

    @PostMapping(value = "/save-doctor")
    public ResponseEntity<String> saveDoctor(@RequestBody String requestDoctor) {

Doctor doctor=setDoctor(requestDoctor);
int doctorId=doctorservice.saveDoctor(doctor);
return new ResponseEntity<String>("Doctor saved with id- "+doctorId,HttpStatus.CREATED);
    }
    private Doctor setDoctor(String requestDoctor){
        JSONObject jsonObject=new JSONObject(requestDoctor);
        Doctor doctor=new Doctor();
        doctor.setDoctorName(jsonObject.getString("doctorName"));
        doctor.setCity(jsonObject.getString("city"));
        doctor.setEmail(jsonObject.getString("email"));
        doctor.setPhoneNumber(jsonObject.getString("phoneNumber"));
        doctor.setSpeciality(jsonObject.getString("speciality"));
        return doctor;
    }
    @GetMapping(value="/doctor")
    public ResponseEntity<String>getDoctor(@Nullable@RequestParam String doctorId){
        JSONArray doctorDetails=doctorservice.getDoctor(doctorId);
        return new ResponseEntity<String>(doctorDetails.toString(),HttpStatus.OK);
    }
    @DeleteMapping(value="/doctor/{doctorId}")
    public void deleteDoctor(@PathVariable String doctorId){
doctorservice.deleteDoctor(doctorId);
    }
    @PutMapping(value="/save-doctor/{doctorId}")
    public ResponseEntity<String>updateDoctor(@PathVariable int doctorId,@RequestBody String doctorData){
        Doctor doctor=setDoctor(doctorData);
        doctorservice.updateDoctor(doctor,doctorId);
        return new ResponseEntity<>("DoctorUpdated",HttpStatus.OK);
    }

    }


























    /*JSONObject json=new JSONObject(requestDoctor);

    Doctor doctor=validateDoctor(json);
    if(null!=doctor){
        doctorservice.saveDoctor(doctor);
        return new ResponseEntity<>("Doctor saved", HttpStatus.CREATED);
    }

    return new ResponseEntity<>("please pass mandatory parameter",HttpStatus.BAD_REQUEST);
}
@GetMapping(value="/doctor")
public List<Doctor> getDoctor(@Nullable @RequestParam String doctorId){  // http://localhost:8080/doctor?doctorId=1

    return doctorservice.getDoctor(doctorId);
}
private Doctor validateDoctor(JSONObject json){
    Doctor doctor=new Doctor();
    List<String>errors=new ArrayList<>();
    if(json.has("doctorId")){
        String doctorId=json.getString("doctorId");
        doctor.setDoctorId(Integer.valueOf(doctorId));
    }
    else{
        errors.add("doctorId");
        return null;
    }
    if(json.has("doctorName")){
        String doctorName=json.getString("doctorName");
        doctor.setDoctorName(doctorName);
    }
    else{
        errors.add("doctorName");
        return null;
    }
    if(json.has("specialization")){
        String specialization=json.getString("specialization");
        doctor.setExperience("experience");
    }
    else{
        errors.add("specialization");
        return null;
    }
    if(json.has("experience")){
        String experience=json.getString("experience");
        doctor.setExperience("experience");
    }
    return doctor;
    }
*/


