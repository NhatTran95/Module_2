package exercise11;

import java.util.Arrays;
import java.util.Scanner;

//Thêm x vào trong mảng tăng nhưng vẫn giữ nguyên tính tăng của mảng
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {2, 3, 4, 6, 8, 9};
        System.out.println(Arrays.toString(numbers));
        System.out.println("nhập số muốn thêm vào mảng: ");
        int number = Integer.parseInt(scanner.nextLine());
        boolean flag = false;
        int index = 0;
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] > number){
                index = i;
                flag = true;
                break;
            }

        }
        if(flag){
            for(int i = numbers.length - 1; i > index; i--){
                int temp = numbers[i];
                numbers[i] = numbers[i-1];
                numbers[i-1] = temp;
            }
            numbers[index] = number;
        } else numbers[numbers.length-1] = number;

        System.out.println(Arrays.toString(numbers));


    }
}
