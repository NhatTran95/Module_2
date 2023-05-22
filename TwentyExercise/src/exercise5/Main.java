package exercise5;
//Kiểm tra mảng có giảm dần hay không
public class Main {
    public static void main(String[] args) {
        int[] numbers = {5,3,2,1};
        for(int i = 0; i < numbers.length -1; i++){
            if(numbers[i] < numbers[i+1]){
                System.out.println("khong giam dan");
                return;
            }
        }
        System.out.println("giam dan");
    }
}
