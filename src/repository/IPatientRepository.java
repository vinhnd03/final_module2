package repository;

import entity.Patient;

import java.util.List;

public interface IPatientRepository {
    void add(Patient patient);

    List<Patient> findAll();

    Patient findByRecordId(String recordId);

    void deleteByRecordId(String recordId);
}
