package dsa.tuf.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PrintTheMatrixInSpiralManner {
    //TODO: Given an M * N matrix, print the elements in a clockwise spiral manner.
    // Return an array with the elements in the order of their appearance when printed in a spiral manner.
    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        System.out.println(spiralOrder(arr));
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(MxN)
    // Space Complexity: O(1)
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int left = 0;
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;

        while (left <= right && top <= bottom){
            for (int col = left; col <= right; col++){
                result.add(matrix[top][col]);
            }
            top++;

            for (int row = top; row <= bottom; row++){
                result.add(matrix[row][right]);
            }
            right--;

            if (top <= bottom){
                for (int col = right; col >= left; col--){
                    result.add(matrix[bottom][col]);
                }
                bottom--;
            }

            if (left <= right){
                for (int row = bottom; row >= top; row--){
                    result.add(matrix[row][left]);
                }
                left++;
            }
        }
        return result;
    }
}
