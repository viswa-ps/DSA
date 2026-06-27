package dsa.tuf.arrays.medium;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle3 {

    //TODO: Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.
    // In Pascal's triangle:
    // The first row has one element with a value of 1.
    // Each row has one more element in it than its previous row.
    // The value of each element is equal to the sum of the elements directly above it when arranged in a triangle format.
    // Example
    // Input: n = 4
    // Output: [[1], [1, 1], [1, 2, 1], [1, 3, 3, 1]]
    // Explanation: The Pascal's Triangle is as follows:
    // 1
    // 1 1
    // 1 2 1
    // 1 3 3 1
    // 1st Row has its value set to 1.
    // All other cells take their value as the sum of the values directly above them
    public static void main(String[] args) {
        System.out.println(pascalTriangleIII(5));
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(N2)
    // Space Complexity: O(N2)
    public static List<List<Integer>> pascalTriangleIII(int n) {
        List<List<Integer>> pascal = new ArrayList<>();
        for (int i = 1; i <= n; i++){
            pascal.add(getRows(i));
        }
        return pascal;
    }

    private static List<Integer> getRows(int r){
        List<Integer> row = new ArrayList<>();
        int res = 1;
        row.add(res);
        for (int i = 1; i < r; i++){
            res *= (r - i);
            res /= i;
            row.add(res);
        }
        return row;
    }
}
