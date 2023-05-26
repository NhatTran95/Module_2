package exercise12;

import java.util.Arrays;

// Xóa tất cả các số âm trong mảng
public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 9, -4, 7, 2, -3, 2, -1, 6};
        System.out.println(Arrays.toString(numbers));
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] < 0){
                numbers[i] = 0;
            }
        }
        for(int i = 0; i < numbers.length; i++){
            if(numbers[i] == 0){
                for(int j = i; j < numbers.length - 1; j++){
                    int temp = numbers[j];
                    numbers[j] = numbers[j+1];
                    numbers[j+1]= temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
