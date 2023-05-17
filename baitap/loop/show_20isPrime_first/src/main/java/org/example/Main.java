package org.example;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập số lượng số nguyên tố cần in ra: ");
        int number = input.nextInt();
        int count = 0;
        int N = 2;
        while (count < number) {
            if (isPrime(N)) {
                System.out.println(N);
                count++;
            }
            N++;
        }
    }
    public static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
