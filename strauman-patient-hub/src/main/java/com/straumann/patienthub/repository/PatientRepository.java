package com.straumann.patienthub.repository;

import com.straumann.patienthub.entity.PatientEntity;
import com.straumann.patienthub.model.Patient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {

    Set<Patient> findAll();
    void deleteById(Long id);
}
