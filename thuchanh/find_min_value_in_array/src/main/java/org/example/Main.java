package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập kích thước của mảng: ");
        int size = input.nextInt();
        int[] numbers = new int[size];
        for(int i = 0; i < numbers.length; i++) {
            System.out.print("Nhập phần tử " +i+ " :");
            numbers[i] = input.nextInt();
        }
        System.out.println("Các phần tử trong mảng là: ");
        for(int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        System.out.println("\nGiá trị nhỏ nhất trong mảng là: " + minValue(numbers));
    }
    public static int minValue(int[] array) {
        int minValue = array[0];
        for(int i = 1; i < array.length; i++) {
            if(array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}
