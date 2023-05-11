
import java.util.Scanner;

public class deleteElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Các phần tử trong mảng:");
        showArray(numbers);
        System.out.println("Nhập phần tử cần xóa trong mảng: ");
        int num = scanner.nextInt();
        int index = -1;
        for(int i = 0; i < numbers.length; i++) {
            if (numbers[i] == num) {
                index = i;
                System.out.printf("Số %s có trong mảng tại vị trí %s \n", num, index);
                break;
            }
        }
        if (index != -1) {
            deleteElement(numbers, index);
        } else System.out.printf("Số %s không có trong mảng \n", num);
    }
    public static void showArray(int[] array) {
        for(int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
    public static void deleteElement(int[] arr, int index) {
        for(int i = index; i < arr.length-1; i++) {
            arr[i] = arr[i+1];
            if(i == arr.length - 2) {
                arr[i+1] = 0;
            }
        }
        System.out.println("Mảng sau khi xóa đi phần tử nhập vào: ");
        showArray(arr);
    }
}
