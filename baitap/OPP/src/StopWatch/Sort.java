package StopWatch;

public class Sort {
    public static void selectionSort(int[] array)
    {
        int min; // chỉ số phần tử nhỏ nhất trong dãy hiện hành
        for (int  i = 0; i < array.length - 1; i++){
            min = i;
            for(int j = i + 1; j < array.length; j++)
                if (array[j] < array[min])
                    min = j; // ghi nhận vị trí phần tử nhỏ nhất
            if (min != i){
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
    }
    public static int[] createArray(int size, int max, int min) {
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = (int) (Math.floor(Math.random()*(max - min + 1) + min));
        }
        return arr;
    }
}
