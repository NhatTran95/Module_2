public class ConcatArray {
    public static void main(String[] args) {
        int[] numbers1 = {1, 2, 3, 4, 5};
        int[] numbers2 = {6, 7, 8};
        int[] numbers3 = new int[numbers1.length + numbers2.length];
        for(int i = 0; i < numbers1.length; i++) {
            numbers3[i] = numbers1[i];
        }
        for(int j = 0; j < numbers2.length; j++) {
            numbers3[numbers1.length+j] = numbers2[j];
        }
        showArray(numbers3);

    }
    public static void showArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "\t");
        }
        System.out.println();
    }
}
