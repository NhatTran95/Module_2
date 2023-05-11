//Ứng dụng cho phép nhập vào lần lượt các phần tử của một mảng (tối đa là 20 phần tử)
// và sau đó đảo ngược thứ tự của các phần tử.
package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.println("nhập vào kích thước của mảng");
            size = input.nextInt();
            if (size > 20) {
                System.out.println("nhập lại kích thước mảng tối đa là 20");
            }
        } while (size > 20);
        int[] array = new int[size];
        for(int i = 0; i < array.length; i++) {
            System.out.println("Nhập phần tử " + i + " :");
            array[i] = input.nextInt();
        }
        System.out.printf("%s%s", "Các phần tử trong mảng: ","");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        for(int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = temp;
        }
        System.out.printf("\n%s%s", "Các phần tử mảng sau khi reverse: ","");
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
    }
}
