import java.util.Scanner;

public class FindMinValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập kích thước mảng: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];
        for (int i = 0; i < numbers.length; i++ ) {
            System.out.print("Nhập phần tử tai vị tri " +i+ ": ");
            numbers[i] = scanner.nextInt();
        }
        System.out.println("các phần tử trong mảng :");
        showArray(numbers);
        int min = minValue(numbers);
        System.out.println("giá trị nhỏ nhất trong mảng là: " + min);
    }
    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
    public static int minValue(int[] array) {
        int minValue = array[0];
        for(int i =1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
            }
        }
        return minValue;
    }
}
