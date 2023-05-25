package exercise.testing;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class NextDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập ngày theo định dạng dd-MM-yyyy :");
        String dateString = scanner.nextLine();
        String nextDateString = nextDate(dateString);
        System.out.println(nextDateString);
    }
    public static String nextDate(String dateString){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(dateString, formatter);
        LocalDate nextDate = date.plusDays(1);
        return formatter.format(nextDate);
    }
}