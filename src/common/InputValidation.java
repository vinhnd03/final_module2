package common;

import view.View;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidation {
    private static Scanner scanner = new Scanner(System.in);

    public static String validateString(String regex, String message) {
        String returnString;
        Pattern pattern = Pattern.compile(regex);
        do {
            returnString = scanner.nextLine();
            Matcher matcher = pattern.matcher(returnString);
            if (!checkEmpty(returnString)) {
                continue;
            }
            if (matcher.matches()) {
                return returnString;
            }
            System.out.println(message);
            System.out.print("Nhập lại: ");
        } while (true);
    }

    public static boolean isValidDate(String date, String pattern) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
        try {
            LocalDate.parse(date, formatter);
            return true;
        } catch (DateTimeException e) {
            return false;
        }
    }

    public static String validateDate(String pattern, String message) {
        String date;
        String regex = "^\\d{2}-\\d{2}-\\d{4}$";
        Pattern patt = Pattern.compile(regex);
        do {
            date = scanner.nextLine().trim();
            Matcher matcher = patt.matcher(date);
            if (matcher.matches() && isValidDate(date, pattern)) {
                return date;
            } else {
                System.out.println(message);
                System.out.print("Nhập lại: ");
            }
        } while (true);
    }

    public static boolean checkDateOut(String dateIn, String dateOut) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate localDateIn = LocalDate.parse(dateIn, formatter);
        LocalDate localDateOut = LocalDate.parse(dateOut, formatter);
        Period period = Period.between(localDateIn, localDateOut);
        if (period.isNegative()) {
            System.out.println("Ngày xuất viện không thể trước ngày vào viện");
            return false;
        }
        return true;
    }

    private static boolean checkEmpty(String string) {
        if (string == null || string.trim().isEmpty()) {
            System.out.println("Không được để trống");
            System.out.print("Nhập lại: ");
            return false;
        }
        return true;
    }

    public static long validateInteger(int min, int max, String message){
        long number;
        do{
            number = Integer.parseInt(scanner.nextLine());

            if(number > 0 && number >= min && number <= max){
                return number;
            }
            System.out.println(message);
            System.out.print("Nhập lại: ");
        }while (true);
    }


    public static String chooseVipType() {
        String[] typeArray = {"VIP I", "VIP II", "VIP III"};
        do {
            int choice = View.displayVipType();
            if (choice < 1 || choice > 3) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }
            return typeArray[choice - 1];
        } while (true);
    }
}
