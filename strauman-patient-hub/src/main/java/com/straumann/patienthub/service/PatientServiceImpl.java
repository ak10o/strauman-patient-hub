package com.straumann.patienthub.service;

import com.straumann.patienthub.exception.PatientNotFoundException;
import com.straumann.patienthub.model.Patient;
import com.straumann.patienthub.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    @Cacheable(value = "patients")
    public Set<Patient> getAllPatients() {
        return patientRepository.findAll();
    }

    @Override
    @Cacheable(value = "patients", key = "#id")
    public Patient getPatientById(Long id) {
        Optional<Patient> patient = patientRepository.findById(id);
        if (patient == null) {
            throw new PatientNotFoundException("Patient not found with id: " + id);
        }
        return patient.get();
    }

    @Override
    @CachePut(value = "patients", key = "#result.id")
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    @CacheEvict(value = "patients", key = "#id")
    public void deletePatientById(Long id) {
        patientRepository.deleteById(id);
    }
}
