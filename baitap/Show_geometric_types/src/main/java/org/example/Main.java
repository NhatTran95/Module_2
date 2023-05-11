package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Menu");
        System.out.println("Chọn 1: Vẽ hình chữ nhật");
        System.out.println("Chọn 2: Vẽ hình tam giác vuông");
        System.out.println("Chọn 3: Vẽ hình tam giác cân");
        System.out.println("Chọn 0: Exit");
        System.out.println("Nhập sự lựa chọn: ");
        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                printTheRectangle();
                break;
            case 2:
                printTheSquareTriangle();
                break;
            case 3:
                printIsoscelesTriangle();
                break;
            case 0:
                System.exit(0);
        }
    }
    public static void printTheRectangle() {
        for (int i = 1; i < 5; i++) {
            for (int j = 1; j < 12; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }
    public static void printTheSquareTriangle() {
        for (int i = 1; i <6; i++) {
            for (int j = 1; j <=i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void printIsoscelesTriangle() {
        int rows = 5;
        for(int i = 1; i <= rows; i++) {
            for(int space = 1; space <= rows - i; space++) {
                System.out.print(" ");
            }
            for(int j = 1; j <= 2 * i - 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
