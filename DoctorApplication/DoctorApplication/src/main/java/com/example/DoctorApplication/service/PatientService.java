package com.example.DoctorApplication.service;

import com.example.DoctorApplication.dao.PatientRepository;
import com.example.DoctorApplication.model.Doctor;
import com.example.DoctorApplication.model.Patient;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
@Autowired
    PatientRepository patientRepository;
    public int savePatient(Patient patient){
        Patient patientObj=patientRepository.save(patient);
        return patient.getPatientId();

    }
    public JSONArray getPatient(String patientId){
        JSONArray patientArray=new JSONArray();
        if(null!=patientId && patientRepository.findById(Integer.valueOf(patientId)).isPresent()){
            Patient patient=patientRepository.findById(Integer.valueOf(patientId)).get();
            JSONObject patientObj=setPatient(patient);
            return patientArray.put(patientObj);
        }
        else{
            List<Patient> patientList=patientRepository.findAll();
            for(Patient patient:patientList){
                JSONObject patientObj=setPatient(patient);
                patientArray.put(patientObj);

            }
        }
        return patientArray;
    }
    private JSONObject setPatient(Patient patient){
        JSONObject jsonObject=new JSONObject();
         jsonObject.put("patientId",patient.getPatientId());
        jsonObject.put("patientName",patient.getPatientName());
        jsonObject.put("patientCity",patient.getPatientCity());
        jsonObject.put("patientEmail",patient.getPatientEmail());
        jsonObject.put("patientPhoneNumber",patient.getPatientPhoneNumber());
        jsonObject.put("symptom",patient.getSymptom());
        return jsonObject;
    }
    public void deletePatient(String patientId){
        patientRepository.deleteById(Integer.valueOf(patientId));
    }
    }

