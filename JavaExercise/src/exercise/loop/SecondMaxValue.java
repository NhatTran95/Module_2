package exercise.loop;

public class SecondMaxValue {
    public static void main(String[] args) {
        int[] numbers = {9, 7, 5, 6, 8, 2, 15, 11, 4};
        int max = numbers[0];
        for(int itemp : numbers){
            if(itemp > max){
                max = itemp;
            }
        }
        int secondMax = 0;
        for(int itemp : numbers){
            if(itemp > secondMax && itemp != max ){
                secondMax = itemp;
            }
        }
        System.out.println("gia tri lon thu 2 trong mang la: " + secondMax);
    }

}
