package com.example.DoctorApplication.service;

import com.example.DoctorApplication.dao.DoctorRepository;
import com.example.DoctorApplication.model.Doctor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.List;

@Service
public class DoctorService {
    @Autowired
    DoctorRepository doctorRepository;
    public int saveDoctor(Doctor doctor){
        Doctor doctorobj=doctorRepository.save(doctor);
        return doctorobj.getDoctorId();

    }
    public JSONArray getDoctor(String doctorId){
        JSONArray doctorArray=new JSONArray();
       if(null!=doctorId && doctorRepository.findById(Integer.valueOf(doctorId)).isPresent()){
    Doctor doctor=doctorRepository.findById(Integer.valueOf(doctorId)).get();
           JSONObject doctorObj=setDoctor(doctor);
           return doctorArray.put(doctorObj);
        }
       else{
           List<Doctor>doctorList=doctorRepository.findAll();
           for(Doctor doctor:doctorList){
               JSONObject doctorObj=setDoctor(doctor);
               doctorArray.put(doctorObj);

           }
       }
       return doctorArray;
    }
    private JSONObject setDoctor(Doctor doctor){
      JSONObject jsonObject=new JSONObject();
      jsonObject.put("doctorId",doctor.getDoctorId());
        jsonObject.put("doctorName",doctor.getDoctorName());
        jsonObject.put("city",doctor.getCity());
        jsonObject.put("email",doctor.getEmail());
        jsonObject.put("phoneNumber",doctor.getPhoneNumber());
        return jsonObject;
    }
public void deleteDoctor(String doctorId){
        doctorRepository.deleteById(Integer.valueOf(doctorId));
}

    public void updateDoctor(Doctor newdoctor, int doctorId) {
        if(doctorRepository.findById(doctorId).isPresent()){
    Doctor doctor=doctorRepository.findById(doctorId).get();
    newdoctor.setDoctorId(doctor.getDoctorId());
    doctorRepository.save(newdoctor);
        }
    }
}

