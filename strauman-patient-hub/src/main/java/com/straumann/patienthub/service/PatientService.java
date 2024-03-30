package com.straumann.patienthub.service;

import com.straumann.patienthub.model.Patient;

import java.util.Set;

public interface PatientService {

    Set<Patient> getAllPatients();

    Patient getPatientById(Long id);

    Patient savePatient(Patient patient);

    void deletePatientById(Long id);
}
