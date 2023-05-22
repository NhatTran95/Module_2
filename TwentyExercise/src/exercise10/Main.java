package exercise10;
//Thêm 1 phần tử x vào mảng tại vị trí k
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {1, 2, 4, 5, 6, 8, 9, 7, 3, 10};
        System.out.println("Mảng ban đầu: " + Arrays.toString(numbers));
        System.out.println("Nhập số muốn thêm vào mảng:");
        int num = scanner.nextInt();
        System.out.println("Nhập vị trí muốn thêm:");
        int index = scanner.nextInt();
        while (index < 0 || index > numbers.length-1 ){
                System.out.println("Hãy nhập lại vị trí muốn thêm trong giới hạn từ 0 đến " + (numbers.length-1));
                index = scanner.nextInt();
        }
        for (int i = numbers.length - 1; i > index ; i--) {
            int temp = numbers[i];
            numbers[i] = numbers[i - 1];
            numbers[i - 1] = temp;
        }
        numbers[index] = num;
        System.out.println("Mảng sau khi thay đổi: " + Arrays.toString(numbers));
    }
}
