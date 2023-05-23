package exercise.introdutionToJava;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rate = 23000;
        System.out.println("Enter USD: ");
        float USD = scanner.nextFloat();
        float VND = USD * rate;
        System.out.println(USD + " USD = " + VND + " VND");
    }
}
