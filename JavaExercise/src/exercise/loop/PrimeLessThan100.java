package exercise.loop;


public class PrimeLessThan100 {
    public static void main(String[] args) {
        int N = 2;
        while (N < 100) {
            if (isPrime(N)) {
                System.out.println(N);
            }
            N++;
        }
    }
    public static boolean isPrime(int num) {
        for(int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
