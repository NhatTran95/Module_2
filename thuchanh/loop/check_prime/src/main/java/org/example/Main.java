package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int num = scanner.nextInt();
        if (isPrime(num)) {
            System.out.printf("%s is a Prime", num);
        } else System.out.printf("%s is Not a Prime", num);
    }
    public static boolean isPrime(int number) {
        int i = 2;
        boolean resurl = true;
        if (number < 2) resurl = false;
        while(i <= Math.sqrt(number)) {
            if (number % i == 0) {
                resurl = false;
                break;
            }
            i++;
        }
        return resurl;
    }
}
