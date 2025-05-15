package repository.impl;

import common.ReadAndWriteFile;
import entity.NormalPatient;
import entity.Patient;
import entity.VipPatient;
import repository.IPatientRepository;

import java.util.ArrayList;
import java.util.List;

public class PatientRepository implements IPatientRepository {
    private static final String PATH = "src/data/patient.csv";

    @Override
    public void add(Patient patient) {
        List<String> stringList = new ArrayList<>();
        stringList.add(patient.toCSVFile());
        ReadAndWriteFile.writeFileCSV(PATH, stringList, true);
    }

    @Override
    public List<Patient> findAll() {
        List<Patient> patientList = new ArrayList<>();
        List<String> stringList = ReadAndWriteFile.readFileCSV(PATH);
        for (String s : stringList){
            String[] arr = s.split("\\s*,\\s*");
            if(arr[7] != ""){
                patientList.add(new NormalPatient(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3],
                        arr[4], arr[5], arr[6], Long.parseLong(arr[7])));
            }else{
                patientList.add(new VipPatient(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3],
                        arr[4], arr[5], arr[6], arr[8], arr[9]));
            }
        }
        return patientList;
    }

    @Override
    public Patient findByRecordId(String recordId) {
        for (Patient patient : findAll()){
            if(patient.getRecordId().equalsIgnoreCase(recordId)){
                return patient;
            }
        }
        return null;
    }

    @Override
    public void deleteByRecordId(String recordId) {
        List<Patient> patients = findAll();
        for(int i = 0; i < patients.size(); i++){
            if(patients.get(i).getRecordId().equalsIgnoreCase(recordId)){
                patients.remove(i);
                break;
            }
        }
        List<String> stringList = new ArrayList<>();
        for(Patient patient : patients){
            stringList.add(patient.toCSVFile());
        }
        ReadAndWriteFile.writeFileCSV(PATH, stringList, false);
    }
}
