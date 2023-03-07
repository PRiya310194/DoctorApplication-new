package com.example.DoctorApplication.controller;

import com.example.DoctorApplication.dao.DoctorRepository;
import com.example.DoctorApplication.model.Doctor;
import com.example.DoctorApplication.model.Patient;
import com.example.DoctorApplication.service.PatientService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.*;

@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

@PostMapping(value="/save-patient")
    public ResponseEntity<String> savePatient(@RequestBody String requestPatient) {

        Patient patient = setPatient(requestPatient);
        int patientId = patientService.savePatient(patient);
        return new ResponseEntity<String>("Patient saved with id- " + patientId, HttpStatus.CREATED);
    }

    private Patient setPatient(String requestPatient) {
        JSONObject jsonObject = new JSONObject(requestPatient);
        Patient patient = new Patient();
        patient.setPatientName(jsonObject.getString("patientName"));
        patient.setPatientCity(jsonObject.getString("patientCity"));
        patient.setPatientEmail(jsonObject.getString("patientEmail"));
        patient.setPatientPhoneNumber(jsonObject.getString("patientPhoneNumber"));
        patient.setSymptom(jsonObject.getString("symptom"));
        return patient;

    }
    @GetMapping(value="/patient")
    public ResponseEntity<String>getPatient(@Nullable @RequestParam String patientId){
        JSONArray patientDetails=patientService.getPatient(patientId);
        return new ResponseEntity<String>(patientDetails.toString(),HttpStatus.OK);
    }

    @DeleteMapping(value="/patient/{patientId}")
    public void deletePatient(@PathVariable String patientId){
        patientService.deletePatient(patientId);
    }
}
