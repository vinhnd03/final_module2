package entity;

public class VipPatient extends Patient{
    private String vipType;
    private String time;

    public VipPatient(int patientNumber, String recordId, String patientId, String name, String dateIn, String dateOut, String reason, String vipType, String time) {
        super(patientNumber, recordId, patientId, name, dateIn, dateOut, reason);
        this.vipType = vipType;
        this.time = time;
    }

    public VipPatient(String recordId, String patientId, String name, String dateIn, String dateOut, String reason, String vipType, String time) {
        super(recordId, patientId, name, dateIn, dateOut, reason);
        this.vipType = vipType;
        this.time = time;
    }

    public String getVipType() {
        return vipType;
    }

    public void setVipType(String vipType) {
        this.vipType = vipType;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public String toString() {
        return super.toString() +
                "vipType='" + vipType + '\'' +
                ", timeline='" + time + '\'' +
                '}';
    }

    @Override
    public String toCSVFile() {
        return super.toCSVFile() + ",," + vipType + "," + time;
    }
}
