package exercise7;
//Sắp xếp số dương tăng dần, các số âm giữ nguyên vị trí
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {-5, 3, 2, -1, 0, -3, 4};
        selectionSort(numbers);
        System.out.println(Arrays.toString(numbers));

    }
    public static void selectionSort(int[] array)
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
}
