package entity;

public class NormalPatient extends Patient {
    private long fee;

    public NormalPatient(int patientNumber, String recordId, String patientId, String name, String dateIn, String dateOut, String reason, long fee) {
        super(patientNumber, recordId, patientId, name, dateIn, dateOut, reason);
        this.fee = fee;
    }

    public NormalPatient(String recordId, String patientId, String name, String dateIn, String dateOut, String reason, long fee) {
        super(recordId, patientId, name, dateIn, dateOut, reason);
        this.fee = fee;
    }

    public long getFee() {
        return fee;
    }

    public void setFee(long fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return super.toString() +
                "fee=" + fee +
                '}';
    }

    @Override
    public String toCSVFile() {
        return super.toCSVFile() + "," + fee + ",,";
    }
}
