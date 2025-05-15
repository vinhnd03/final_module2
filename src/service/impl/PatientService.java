package service.impl;

import entity.Patient;
import repository.IPatientRepository;
import repository.impl.PatientRepository;
import service.IPatientService;

import java.util.List;

public class PatientService implements IPatientService {
    private IPatientRepository repository = new PatientRepository();

    @Override
    public void add(Patient patient) {
        repository.add(patient);
    }

    @Override
    public List<Patient> findAll() {
        return repository.findAll();
    }

    @Override
    public Patient findByRecordId(String recordId) {
        return repository.findByRecordId(recordId);
    }

    @Override
    public void deleteByRecordId(String recordId) {
        repository.deleteByRecordId(recordId);
    }
}
