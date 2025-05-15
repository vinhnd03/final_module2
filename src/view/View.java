package view;

import common.InputValidation;
import controller.PatientController;
import entity.NormalPatient;
import entity.Patient;
import entity.VipPatient;

import java.util.List;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        PatientController.displayMenu();
    }

    public static NormalPatient inputNormalPatient() {
        System.out.println("Nhập mã bệnh án: ");
        String recordId;
        do {
            recordId = InputValidation.validateString("^BA-\\d{3}$", "Mã bệnh án không hợp lệ");
        }while (PatientController.checkExistedRecordId(recordId));

        System.out.println("Nhập mã bệnh nhân: ");
        String patientId = InputValidation.validateString("^BN-\\d{3}$", "Mã bệnh nhân không hợp lệ");
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày nhập viện (dd-MM-yyyy): ");
        String dateIn = InputValidation.validateDate("dd-MM-yyyy", "Ngày nhập viên không hợp lệ");
        System.out.println("Nhập ngày xuất viện (dd-MM-yyyy): ");
        String dateOut;
        do {
            dateOut = InputValidation.validateDate("dd-MM-yyyy", "Ngày xuất viên không hợp lệ");
        }while (!InputValidation.checkDateOut(dateIn, dateOut));
        System.out.println("Nhập lý do: ");
        String reason = scanner.nextLine();
        System.out.println("Nhập chi phí: ");
        long fee = InputValidation.validateInteger(0, Integer.MAX_VALUE, "Chi phí không hợp lệ");
        return new NormalPatient(recordId, patientId, name, dateIn, dateOut, reason, fee);
    }

    public static VipPatient inputVipPatient() {
        System.out.println("Nhập mã bệnh án: ");
        String recordId;
        do {
            recordId = InputValidation.validateString("^BA-\\d{3}$", "Mã bệnh án không hợp lệ");
        }while (PatientController.checkExistedRecordId(recordId));
        System.out.println("Nhập mã bệnh nhân: ");
        String patientId = InputValidation.validateString("^BN-\\d{3}$", "Mã bệnh nhân không hợp lệ");
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        System.out.println("Nhập ngày nhập viện (dd-MM-yyyy): ");
        String dateIn = InputValidation.validateDate("dd-MM-yyyy", "Ngày nhập viên không hợp lệ");
        System.out.println("Nhập ngày xuất viện (dd-MM-yyyy): ");
        String dateOut;
        do {
            dateOut = InputValidation.validateDate("dd-MM-yyyy", "Ngày xuất viên không hợp lệ");
        }while (!InputValidation.checkDateOut(dateIn, dateOut));
        System.out.println("Nhập lý do: ");
        String reason = scanner.nextLine();
        System.out.println("Nhập gói Vip: ");
        String vipType = InputValidation.chooseVipType();
        System.out.println("Nhập thời hạn: ");
        String time = InputValidation.validateDate("dd-MM-yyyy", "Thời hạn không hợp lệ");
        return new VipPatient(recordId, patientId, name, dateIn, dateOut, reason, vipType, time);
    }

    public static void displayPatientList(List<Patient> patientList) {
        for (Patient patient : patientList){
            System.out.println(patient);
        }
    }

    public static String inputRecordId() {
        System.out.println("Nhập mã bệnh án cần xóa");
        return scanner.nextLine();
    }

    public static boolean confirmDelete() {
        System.out.println("Bạn có muốn xóa bạn án này (yes / no): ");
        String confirm = scanner.nextLine();
        if(confirm.equalsIgnoreCase("yes")){
            return true;
        }
        return false;
    }

    public static int displayVipType() {
        System.out.println("Danh sách các gói Vip: ");
        System.out.println("1. VIP I");
        System.out.println("2. VIP II");
        System.out.println("2. VIP III");
        System.out.print("Lựa chọn: ");
        return Integer.parseInt(scanner.nextLine());
    }
}
