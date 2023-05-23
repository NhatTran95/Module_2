package practice.loop;

import java.util.Scanner;

public class Loan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập số tiền cho vay: ");
        double money = scanner.nextDouble();
        System.out.println("Nhập lãi suất: ");
        double interestRate = scanner.nextDouble();
        System.out.println("Nhập số tháng vay: ");
        int month = scanner.nextInt();
        double totalIntersest = money * (interestRate/100)/12 * month;
        double totalMoney = money + totalIntersest;
        System.out.printf("Tổng số tiền phải trả khi vay %.2f triệu với lãi suất %.2f phần trăm trên năm trong %s tháng là %.2f triệu", money, interestRate, month, totalMoney);
    }
}
