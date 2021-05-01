package com.mediscreen.patient.service;

import java.util.List;

import javax.transaction.Transactional;

import com.mediscreen.patient.model.Patient;
import com.mediscreen.patient.repository.PatientRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    public List<Patient> listAll() {
        return patientRepository.findAll();
    }

    public Patient findById(int id) {
        return patientRepository.findById(id);
    }

    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient updatePatient2(Patient patient) {
        return patientRepository.saveAndFlush(patient);
    }
}
