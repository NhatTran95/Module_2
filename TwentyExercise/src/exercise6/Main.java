package exercise6;

import java.lang.reflect.Array;
import java.util.Arrays;

//Hãy cho biết tất cả các phần tử trong mảng a có nằm trong mảng b không
public class Main {
    public static void main(String[] args) {
        int[] a = {1, 3, 4, 4, 6};
        int[] b = {5, 8, 6, 3, 3, 4, 7, 2, 1};
        System.out.println("a[] = " + Arrays.toString(a));
        System.out.println("b[] = " + Arrays.toString(b));
        int count = 0;
        for(int i = 0; i < a.length; i++){
            for(int j = 0; j < b.length; j++){
                if(a[i] == b[j]){
                    count++;
                    break;
                }
            }
        }
        if(count == a.length){
            System.out.println("tất cả các phần tử trong mảng a có nằm trong mảng b");
        } else System.out.println("tất cả các phần tử trong mảng a không nằm trong mảng b");
    }
}
