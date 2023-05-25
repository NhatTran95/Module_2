package exercise.testing;

import java.util.Scanner;

public class Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap canh a: ");
        int a = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap canh b: ");
        int b = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap canh c: ");
        int c = Integer.parseInt(scanner.nextLine());
        System.out.println(triangleStyle(a, b, c));

    }
    public static String triangleStyle(int a, int b, int c){
        if (a + b > c && a + c > b && b + c > a){
            if(a == b && b == c && c==a ){
                return "tam giác đều";
            }
            else if(a == b || a == c || c == b){
                return "tam giác cân";
            }
            else if (a*a == b*b + c*c || b*b == a*a + c*c || c*c == a*a + b*b) {
                return "tam giác vuông";

            } else return "tam giác thường";

        }
        else return "không phải là tam giác";
    }
}
