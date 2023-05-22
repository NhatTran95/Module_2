package exercise8;

import java.util.Arrays;

//Sắp xếp lẻ tăng dần nhưng giá trị khác giữ nguyên vị trí
public class Main {
    public static void main(String[] args) {
        int[] numbers = {8, 5, 3, 2, 7, 0, 9, 4, 6, 1};
        System.out.println(Arrays.toString(numbers));
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void selectionSort(int[] array) {
        int min;
        for (int  i = 0; i < array.length - 1; i++){
            if(array[i] % 2 != 0){
                min = i;
                for(int j = i + 1; j < array.length; j++)
                    if (array[j] < array[min] && array[j] % 2 != 0)
                        min = j;
                if (min != i){
                    int temp = array[min];
                    array[min] = array[i];
                    array[i] = temp;
                }
            }

        }
    }

}
