package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhap so a = ");
        int a = input.nextInt();
        System.out.println("Nhap so b = ");
        int b = input.nextInt();
        int result = findUCLN(a,b);
        if (result == -1) {
            System.out.printf("UCLN cua %s va %s la %s", a, b, "khong co");
        } else System.out.printf("UCLN cua %s va %s la %s", a, b, result);
    }
    public static int findUCLN(int a, int b) {
        if (a == 0 && b == 0)
            return -1;
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
