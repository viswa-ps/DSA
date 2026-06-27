package dsa.tuf.arrays.medium;

import java.util.Arrays;

public class PascalsTriangle2 {
    //TODO: Given an integer r, return all the values in the rth row (1-indexed) in Pascal's Triangle in correct order.
    // In Pascal's triangle:
    // The first row has one element with a value of 1.
    // Each row has one more element in it than its previous row.
    // The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
    // Example 1
    // Input: r = 4
    // Output: [1, 3, 3, 1]
    // Explanation:
    // The Pascal's Triangle is as follows:
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // ....
    // Thus the 4th row is [1, 3, 3, 1]
    public static void main(String[] args) {
        System.out.println(Arrays.toString(pascalTriangleII(4)));
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(R)
    // Space Complexity: O(1)
    public static int[] pascalTriangleII(int r) {
        int[] row = new int[r];
        int res = 1;
        row[0] = res;
        for (int i = 1; i < r; i++){
            res *= (r - i);
            res /= i;
            row[i] = res;
        }
        return row;
    }
}
