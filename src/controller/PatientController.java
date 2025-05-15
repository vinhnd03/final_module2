package controller;

import common.DupilcateMedicalRecordException;
import entity.NormalPatient;
import entity.Patient;
import entity.VipPatient;
import service.IPatientService;
import service.impl.PatientService;
import view.View;

import java.util.List;
import java.util.Scanner;

public class PatientController {
    private static Scanner scanner = new Scanner(System.in);
    private static IPatientService patientService = new PatientService();

    public static void displayMenu() {
        do {
            System.out.println("========[MENU QUẢN LÝ BỆNH ÁN]========");
            System.out.println("1. Thêm mới");
            System.out.println("2. Xóa");
            System.out.println("3. Xem danh sách");
            System.out.println("4. Thoát");
            System.out.println("======================================");
            System.out.print("Lựa chọn: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("1. Thêm mới");
                        add();
                        break;
                    case 2:
                        System.out.println("2. Xóa");
                        delete();
                        break;
                    case 3:
                        System.out.println("3. Xem danh sách");
                        display();
                        break;
                    case 4:
                        System.out.println("Tạm biệt");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Không hợp lệ");
                        break;
                }
            } catch (NumberFormatException e) {
                e.printStackTrace();
                System.out.println("Nhập sai định dạng số");
            }
        } while (true);
    }

    private static void delete() {
        String recordId = View.inputRecordId();
        Patient patient = patientService.findByRecordId(recordId);
        if(patient == null){
            System.out.println("Không tìm thấy bệnh án");
            return;
        }
        if(View.confirmDelete()){
            patientService.deleteByRecordId(recordId);
            System.out.println("Xóa thành công");
        }

    }

    private static void display() {
        List<Patient> patientList = patientService.findAll();
        View.displayPatientList(patientList);
    }

    private static void add(){
        boolean flag = true;
        do {
            System.out.println("Chọn bệnh án muốn thêm mới");
            System.out.println("1. Bệnh án bình thường");
            System.out.println("2. Bệnh án Vip");
            System.out.println("3. Trờ về");
            System.out.print("Lựa chọn: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addNormalPatient();
                    break;
                case 2:
                    addVipPatient();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    System.out.println("Không hợp lệ");
            }
        }while (flag);
    }

    private static void addVipPatient() {
        Patient patient = View.inputVipPatient();
        patientService.add(patient);
    }

    private static void addNormalPatient() {
        Patient patient = View.inputNormalPatient();
        patientService.add(patient);
    }

    public static boolean checkExistedRecordId(String recordId) {
        Patient patient = patientService.findByRecordId(recordId);
        boolean check = false;
        try {
            if(patient != null){
                check = true;
                throw new DupilcateMedicalRecordException("Mã bệnh án đã tồn tại");

            }
        }catch (DupilcateMedicalRecordException e){
            System.out.println(e.getMessage());
        }
        return check;
    }
}
