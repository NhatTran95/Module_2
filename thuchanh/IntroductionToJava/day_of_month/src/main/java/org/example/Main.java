package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Nhập vào một tháng cho biết số ngày của tháng đó.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tháng: ");
        int month = scanner.nextInt();
        switch (month) {
            case 2:
                System.out.println("Month " + month + " has 28 or 29 day");
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Month " + month + " has 31 day");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Month " + month + " has 30 day");
                break;
            default:
                System.out.println("Nhập tháng sai, tháng từ 1 đến 12");

        }
    }
}
