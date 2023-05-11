package org.example;

import java.util.Scanner;

public class ConvertCurrency {
    public static void main(String[] args) {
        convertCurrncy();
    }
    public static void convertCurrncy() {
        int rate = 23000;
        Scanner input = new Scanner(System.in);
        int choice;
        boolean checkInputContinue;
        do {
            checkInputContinue = true;
            System.out.println("Bạn muốn nhập tiền USD hay VND");
            System.out.println("Chọn 1 để nhập USD");
            System.out.println("Chọn 2 để nhập VND");
            choice = input.nextInt();
            if (choice == 1 || choice == 2) {
                checkInputContinue = false;
            } else System.out.println("Nhập không đúng vui lòng nhập lại.");
        } while (checkInputContinue);
        double total;
        switch (choice) {
            case 1:
                System.out.println("nhập số tiền USD:");
                double money = input.nextDouble();
                total = money * rate;
                System.out.printf("%s USD tương ứng vơí %.0f VND", money, total);
                break;
            case 2:
                System.out.println("nhập số tiền VND:");
                double money1 = input.nextDouble();
                total = money1 / rate;
                System.out.printf("%.0f VND tương ứng vơí %.2f USD", money1, total);
        }

    }
}
