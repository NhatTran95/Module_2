package exercise2;

import java.util.Arrays;

//Hãy liệt kê các vị trí mà giá trị tại đó là số nguyên tố trong mảng 1 chiều các số nguyên
public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 4, 2, 5, 8, 9, 7, 11, 12};
        System.out.println(Arrays.toString(numbers));
        System.out.println("Prime in array at index: ");
        for(int i = 0; i < numbers.length; i++){
            if (isPrime(numbers[i])) {
                System.out.print(i+" ");
            }
        }
    }
    public static boolean isPrime(int num){
        if(num < 2) {
            return false;
        }
        else {
            for(int i = 2; i <= Math.sqrt(num); i++){
                if (num % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}
