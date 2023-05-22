package exercise9;
//Sắp xếp số dương tăng dần, âm giảm dần. Vị trí tương đối không thay đổi
import java.util.Arrays;

//Sắp xếp số dương tăng dần, âm giảm dần. Vị trí tương đối không thay đổi
public class Main {
    public static void main(String[] args) {
        int[] numbers = {8, -5, 3, 2, -7, 0, 9, 4, -6, -1};
        System.out.println(Arrays.toString(numbers));
        selectionSortNegativeNumbersIncrease(numbers);
        selectionSortPositiveNumbersIncrease(numbers);
        System.out.println(Arrays.toString(numbers));
    }
    public static void selectionSortPositiveNumbersIncrease(int[] array)
    {
        int min;
        for (int  i = 0; i < array.length - 1; i++){
            if(array[i] >= 0){
                min = i;
                for(int j = i + 1; j < array.length; j++)
                    if (array[j] < array[min] && array[j] >= 0)
                        min = j;
                if (min != i){
                    int temp = array[min];
                    array[min] = array[i];
                    array[i] = temp;
                }
            }

        }
    }
    public static void selectionSortNegativeNumbersIncrease(int[] array)
    {
        int max;
        for (int  i = 0; i < array.length - 1; i++){
            if(array[i] < 0){
                max = i;
                for(int j = i + 1; j < array.length; j++)
                    if (array[j] > array[max] && array[j] < 0)
                        max = j;
                if (max != i){
                    int temp = array[max];
                    array[max] = array[i];
                    array[i] = temp;
                }
            }

        }
    }
}
