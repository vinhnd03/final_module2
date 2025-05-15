package common;

import entity.Patient;
import service.IPatientService;
import service.impl.PatientService;

import java.util.List;

public class UpdateId {
    private static int getCurrentNumber(){
        IPatientService patientService = new PatientService();
        List<Patient> patientList = patientService.findAll();
        if(patientList.isEmpty()){
            return 0;
        }
        return patientList.get(patientList.size() - 1).getPatientNumber();
    }

    public static int currentPatientNumber = getCurrentNumber() + 1;
}
