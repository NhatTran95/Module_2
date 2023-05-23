package exercise14;

import java.util.Arrays;

//Xóa tất cả các phần tử trùng nhau trong mảng và chỉ giữ lại duy nhất 1 phần tử
public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 5, 4, 6, 8, 3, 1, 7, 5, 4, 2, 1, 9};
        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] == numbers[i]) {
                    numbers[j] = 0;
                }
            }
        }
//        System.out.println(Arrays.toString(numbers));
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == 0) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
