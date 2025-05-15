package entity;

import common.UpdateId;

public abstract class Patient {
    private int patientNumber;
    private String recordId;
    private String patientId;
    private String name;
    private String dateIn;
    private String dateOut;
    private String reason;

    public Patient(int patientNumber, String recordId, String patientId, String name, String dateIn, String dateOut, String reason) {
        this.patientNumber = patientNumber;
        this.recordId = recordId;
        this.patientId = patientId;
        this.name = name;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
    }

    public Patient(String recordId, String patientId, String name, String dateIn, String dateOut, String reason) {
        this.patientNumber = UpdateId.currentPatientNumber;
        this.recordId = recordId;
        this.patientId = patientId;
        this.name = name;
        this.dateIn = dateIn;
        this.dateOut = dateOut;
        this.reason = reason;
    }

    public int getPatientNumber() {
        return patientNumber;
    }

    public void setPatientNumber(int patientNumber) {
        this.patientNumber = patientNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateIn() {
        return dateIn;
    }

    public void setDateIn(String dateIn) {
        this.dateIn = dateIn;
    }

    public String getDateOut() {
        return dateOut;
    }

    public void setDateOut(String dateOut) {
        this.dateOut = dateOut;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    @Override
    public String toString() {
        return "{" +
                "patientNumber=" + patientNumber +
                ", recordId='" + recordId + '\'' +
                ", patientId='" + patientId + '\'' +
                ", name='" + name + '\'' +
                ", dateIn='" + dateIn + '\'' +
                ", dateOut='" + dateOut + '\'' +
                ", reason='" + reason + '\'';
    }

    public String toCSVFile() {
        return patientNumber + "," + recordId + "," + patientId + "," + name + "," + dateIn + "," + dateOut + "," + reason;
    }
}
