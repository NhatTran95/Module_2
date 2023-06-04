package practice.exception.triangle;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IllegalTriangleException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap canh a:");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap canh b:");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap canh c:");
        int c = Integer.parseInt(scanner.nextLine());
        Triangle triangle = new Triangle(a, b, c);
    }
}
