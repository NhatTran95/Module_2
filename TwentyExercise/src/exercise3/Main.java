package exercise3;

import java.util.Arrays;

//Đếm số lượng giá trị tận cùng bằng 5 trong mảng
public class Main {
    public static void main(String[] args) {
        int[] numbers = {15, 123, 25, 5, 136, 1456, 1055, 96};
        System.out.println("Array: "+Arrays.toString(numbers));
        int count = 0;
        for (int i = 0; i < numbers.length; i++){
            if(isNumberHasLastValueis5(numbers[i])){
                count++;
            }
        }
        System.out.print("Quantity numbers has last value is 5 in array is: " +count);

    }
    public static boolean isNumberHasLastValueis5(int num){
        if(num % 10 == 5) {
            return true;
        }
        else return false;
    }
}
