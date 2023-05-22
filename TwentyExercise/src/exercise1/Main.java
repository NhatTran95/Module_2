package exercise1;

import java.util.Arrays;

//Hãy liệt kê các giá trị có toàn chữ số lẻ trong mảng 1 chiều các số nguyên
public class Main {
    //    public static void main(String[] args) {
//        int[] numbers = {123, 124, 235, 456, 357, 135, 1377, 62, 59, 1246, 1, 2};
//        System.out.println("Value of Array: " + Arrays.toString(numbers));
//        System.out.print("All Odd Values of Array: ");
//        listNumbersAllOdd(numbers);
//    }
//
//    public static boolean isOdd(int num){
//        if (num % 2 != 0){
//            return true;
//        } else return false;
//    }
//    public static void listNumbersAllOdd(int[] arr){
//        for(int i = 0; i < arr.length; i++){
//            if(isOdd(arr[i])){
//                int num = arr[i]/10;
//                while (num != 0){
//                    if(isOdd(num)){
//                        num = num/10;
//                    }
//                    else break;
//                }
//                if(num == 0){
//                    System.out.print(arr[i] + " ");
//                }
//            }
//        }
//    }
    public static void main(String[] args) {
        int[] numbers = {123, 124, 235, 456, 357, 135, 1377, 62, 59, 1246, 1, 2};
        System.out.println("Value of Array: "+Arrays.toString(numbers));
        System.out.print("All Odd Values of Array: ");
        for(int i = 0; i < numbers.length; i++){
            boolean flag = true;
            String changeNumberToString = String.valueOf(numbers[i]);
            for(int j = 0; j < changeNumberToString.length();j++){
                int num = Integer.parseInt(String.valueOf(changeNumberToString.charAt(j)));
                if (num % 2 == 0){
                   flag = false;
                   break;
                }
            }
            if(flag == true){
                System.out.print(numbers[i] + " ");
            }
        }
    }

}
