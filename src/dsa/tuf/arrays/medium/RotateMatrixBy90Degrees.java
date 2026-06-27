package dsa.tuf.arrays.medium;

import java.util.Arrays;

public class RotateMatrixBy90Degrees {

    //TODO: Given an N * N 2D integer matrix, rotate the matrix by 90 degrees clockwise.
    // The rotation must be done in place, meaning the input 2D matrix must be modified directly.
    // Example
    // Input: matrix = [[0, 1, 1, 2], [2, 0, 3, 1], [4, 5, 0, 5], [5, 6, 7, 0]]
    // Output: matrix = [[5, 4, 2, 0], [6, 5, 0, 1], [7, 0, 3, 1], [0, 5, 1, 2]]
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        rotateMatrix(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(N2)+O(N2)
    // Space Complexity: O(1)
    public static void rotateMatrix(int[][] matrix) {
        getTranspose(matrix);
        for (int[] ints : matrix) {
            reverseRow(ints);
        }
    }
    private static void getTranspose(int[][] matrix){
        for (int row = 0; row < matrix.length; row++){
            for (int col = row; col < matrix.length; col++){
                if (row != col){
                    int temp = matrix[row][col];
                    matrix[row][col] = matrix[col][row];
                    matrix[col][row] = temp;
                }
            }
        }
    }

    private static void reverseRow(int[] row){
        for (int i = 0; i < row.length / 2; i++){
            int temp = row[i];
            row[i] = row[row.length - i - 1];
            row[row.length - i - 1] = temp;
        }
    }
}
