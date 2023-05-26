package exercise15;

import java.util.Arrays;

//Hãy đưa tất cả các số 1 về đầu mảng
public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 4, 1, 3, 8, 7, 1, 6, 1, 9, 1};
        System.out.println(Arrays.toString(numbers));
        for(int i = 0; i < numbers.length; i++){
            for(int j = numbers.length - 1; j > i; j--){
                if(numbers[j] == 1){
                    int temp = numbers[j];
                    numbers[j] = numbers[j-1];
                    numbers[j-1] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(numbers));
    }
}
