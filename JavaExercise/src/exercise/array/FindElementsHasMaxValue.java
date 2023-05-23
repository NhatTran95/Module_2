package exercise.array;

import java.util.ArrayList;

public class FindElementsHasMaxValue {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4, 5},
                {2, 8, 9, 6, 4},
                {6, 7, 8, 6, 2},
                {3, 4, 7, 5, 9}
        };
        int maxValue = 0;
        int indexRow = -1;
        int indexCol = -1;
        for (int i = 0; i<matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] > maxValue) {
                    maxValue = matrix[i][j];
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        System.out.printf("giá trị lớn nhất trong mảng là %s tại dòng %s cột %s", maxValue, indexRow, indexCol);
        for (int i = 0; i<matrix.length; i++) {
            for(int j = 0; j < matrix[i].length; j++) {
                if(matrix[i][j] == maxValue) {
                    indexRow = i;
                    indexCol = j;
                }
            }
        }
        System.out.printf("\ngiá trị lớn nhất trong mảng là %s tại dòng %s cột %s", maxValue, indexRow, indexCol);
        }

    }

