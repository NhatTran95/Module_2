package practice.introdutionToJava;

import java.util.Scanner;

public class Calculate {
    public static void main(String[] args) {
        System.out.println("Calculate body mass index.");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter weight: ");
        double weight = scanner.nextDouble();
        System.out.println("Enter height: ");
        double height = scanner.nextDouble();
        double bmi = weight / Math.pow(height, 2);
        if (bmi < 18.5) {
            System.out.println("Underweight");
        } else if (bmi < 25.0){
            System.out.println("Normal");
        } else if (bmi < 30.0) {
            System.out.println("Overweight");
        } else {
            System.out.println("Obese");
        }
    }
}
