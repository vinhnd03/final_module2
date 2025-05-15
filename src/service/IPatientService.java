package service;

import entity.NormalPatient;
import entity.Patient;

import java.util.List;

public interface IPatientService {
    void add(Patient patient);

    List<Patient> findAll();

    Patient findByRecordId(String recordId);

    void deleteByRecordId(String recordId);
}
