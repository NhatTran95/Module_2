//Ứng dụng cho phép người dùng lần lượt nhập vào giá trị tài sản
// của các tỷ phú thế giới (đơn vị tỉ đô), tối đa cho phép nhập 20 giá trị,
// sau đó hiển thị giá trị tài sản lớn nhất và vị trí của nó trong danh sách
package practice.array;

import java.util.Scanner;

public class MaxValue {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size;
        do {
            System.out.println("Nhập số giá trị được phép nhập vào: ");
            size = input.nextInt();
            if(size > 20) {
                System.out.println("Hãy nhập lại, số giá trị tối đa là 20!");
            }
        }while (size > 20);
        int[] numbers = new int[size];
        for(int i = 0; i < numbers.length; i++) {
            System.out.println("Nhập giá trị " + (i+1) + " :");
            numbers[i] = input.nextInt();
        }
        System.out.println("Các giá trị đã nhập vào là: ");
        for(int i = 0; i< numbers.length; i++) {
            System.out.print(numbers[i] + "\t");
        }
        int max = 0;
        int index = 0;
        for(int i = 0; i < numbers.length; i++) {
            if(numbers[i] > max) {
                max = numbers[i];
                index =i+1;
            }
        }
        System.out.println("\nGiá trị lớn nhất đã nhập là: " +max+ " tại vị trí: " +index);
    }
}
