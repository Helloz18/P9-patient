package com.mediscreen.patient.controller;

import java.net.URI;
import java.util.List;

import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin("*")
public class PatientController {

    @Autowired
    PatientService patientService;
    
    @GetMapping(path = "/patients")
    public ResponseEntity<List<Patient>> listAllPatients() {
        List<Patient> patients = patientService.listAll();
        if(patients == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(patients);
        }
    }

    @PostMapping(path = "/patient/add")
    public ResponseEntity<Patient> createPatient(@Validated @RequestBody Patient patient) {
           
            Patient patientAdded = patientService.savePatient(patient);

            if(patientAdded == null) {
                return ResponseEntity.noContent().build();
            }

            URI location = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/id")
            .buildAndExpand(patientAdded.getId())
            .toUri();

            return ResponseEntity.created(location).build();
        
    }
   
    @GetMapping(path = "/patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable int id) {
       
        Patient patient = patientService.findById(id);
       
        if(patient == null) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok().body(patient);
        }
    }

    @PutMapping(path = "/patient/{id}")
    public ResponseEntity<Patient> updatePatient(@PathVariable("id") int id, @RequestBody Patient patientWithUpdate){
        
        Patient patient = patientService.findById(id);
       
        if(patient == null || patientWithUpdate == null) {
            return ResponseEntity.noContent().build();
        }

        patient = patientService.savePatient(patientWithUpdate);
        return ResponseEntity.ok().body(patient);
    }
}
