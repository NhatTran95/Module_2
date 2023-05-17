package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice;
        boolean checkValueEnter;
        do {
            checkValueEnter = true;
            System.out.println("chuyển đổi nhiệt độ");
            System.out.println("Nhập 1 để chuyển độ C sang độ F");
            System.out.println("Nhập 2 để chuyển độ F sang độ C");
            System.out.println("Nhập 0 để thoát");
            choice = input.nextInt();
            if(choice == 0 || choice == 1 || choice == 2) {
                checkValueEnter = false;
            } else System.out.println("Hãy nhập lại!");
        }while(checkValueEnter);
        double celsius;
        double fahrenheit;
        switch (choice) {
            case 1:
                System.out.println("Nhập đô C: ");
                celsius = input.nextDouble();
                System.out.printf("%s độ C tương ứng với %.2f độ F", celsius, celsiusToFahrenheit(celsius));
                break;
            case 2:
                System.out.println("Nhập độ F: ");
                fahrenheit = input.nextDouble();
                System.out.printf("%s độ F tương ứng với %.2f độ C", fahrenheit, fahrenheitToCelsius(fahrenheit));
                break;
            case 0:
                System.exit(0);
        }
    }
    public static double celsiusToFahrenheit(double celsius) {
        double fahrenheit = celsius * 9 / 5 + 32;
        return fahrenheit;
    }
    public static double fahrenheitToCelsius(double fahrenheit) {
        double celsius = 5.0 / 9 * (fahrenheit - 32);
        return celsius;
    }
}
