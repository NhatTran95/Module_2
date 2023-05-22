package exercise4;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {1, 2, 3, 4, 5, 0};
        System.out.println(checkArray(numbers));
    }
    public static boolean isNumber0(int num){
        if(num == 0){
            return true;
        }
        else return false;
    }
    public static int checkArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            if(isNumber0(arr[i])){
                return 1;
            }
        }
        return 0;
    }
}
