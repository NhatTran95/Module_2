package exercise.inheritance;

import java.util.Scanner;

public class TriangleTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Triangle triangle = new Triangle();
        System.out.println("nhap canh a:");
        triangle.setSide1(Double.parseDouble(scanner.nextLine()));
        System.out.println("nhap canh b:");
        triangle.setSide2(Double.parseDouble(scanner.nextLine()));
        System.out.println("nhap canh c:");
        triangle.setSide3(Double.parseDouble(scanner.nextLine()));
        System.out.println("nhap mau sac:");
        triangle.setColor(scanner.nextLine());
        System.out.println(triangle);
    }
}
