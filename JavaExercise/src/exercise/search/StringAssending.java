package exercise.search;

import java.util.Scanner;
//SAI!!
public class StringAssending {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap vao mot chuoi:");
        String string = scanner.nextLine();
        char[] stringArray = string.toCharArray();
        char valueMin = stringArray[0];
        int index = 0;
        for(int i = 1; i < stringArray.length; i++){
            if(valueMin > stringArray[i]){
                valueMin = stringArray[i];
                index = i;
            }
        }
        for(int i = index; i < stringArray.length; i++){
            if(valueMin < stringArray[i]){
                System.out.print(valueMin);
                valueMin = stringArray[i];
            }
        }
        System.out.print(valueMin);
    }
}
