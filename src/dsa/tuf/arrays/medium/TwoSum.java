package dsa.tuf.arrays.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //TODO: Given an array of integers nums and an integer target. Return the indices(0 - indexed)
    // of two elements in nums such that they add up to target.
    // Each input will have exactly one solution, and the same element cannot be used twice. Return the answer in any order.
    // Example
    // Input: nums = [1, 6, 2, 10, 3], target = 7
    // Output: [0, 1]
    // Explanation:
    // nums[0] + nums[1] = 1 + 6 = 7
    public static void main(String[] args) {
        int[] arr = {1, 6, 2, 10, 3};
        System.out.println(Arrays.toString(twoSum(arr, 7)));
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(N) + O(N*logN)
    // Space Complexity: O(N)
    public static int[] twoSum(int[] nums, int target) {
        int[][] indexMatrix = new int[nums.length][2];
        // store the value and index of each element in a 2d matrix of n x 2;
        for (int i = 0; i < nums.length; i++) {
            indexMatrix[i][0] = nums[i];
            indexMatrix[i][1] = i;
        }

        // Sort matrix by value;
        Arrays.sort(indexMatrix, (a, b) -> Integer.compare(a[0], b[0]));

        // Apply 2 pointer Logic
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int sum = indexMatrix[left][0] + indexMatrix[right][0];
            if (sum == target) {
                return new int[] {indexMatrix[left][1], indexMatrix[right][1]};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[] {-1, -1};
    }
}
