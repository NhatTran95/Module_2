import java.util.Scanner;

public class AddElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = {1, 2, 3, 5, 6, 7, 8};
        System.out.println("Các phần tử trong mảng:");
        showArray(numbers);
        System.out.println("Nhập số cần chèn");
        int num = scanner.nextInt();
        System.out.println("Nhập vị trí cần chèn");
        int index = scanner.nextInt();
        if(index <= -1 || index >= numbers.length -1) {
            System.out.println("Không chèn được phần tử vào mảng");
        } else {
            System.out.println("Mảng sau khi chèn thêm phần tử:");
            addElement(numbers, index, num);
        }

    }
    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
    public static void addElement(int[] array, int index, int number) {
        for (int i = array.length -1; i > index; i--) {
            array[i] = array[i-1];
        }
        array[index] = number;
        showArray(array);
    }
}
