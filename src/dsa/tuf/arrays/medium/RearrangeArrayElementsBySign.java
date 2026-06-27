package dsa.tuf.arrays.medium;

import java.util.Arrays;

public class RearrangeArrayElementsBySign {
    //TODO: Given an integer array nums of even length consisting of an equal number of positive and negative integers.
    // Return the answer array in such a way that the given conditions are met:
    // Every consecutive pair of integers have opposite signs.
    // For all integers with the same sign, the order in which they were present in nums is preserved.
    // The rearranged array begins with a positive integer.
    // Example
    // Input : nums = [2, 4, 5, -1, -3, -4]
    // Output : [2, -1, 4, -3, 5, -4]
    // Explanation:
    // The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions
    public static void main(String[] args) {
        int[] arr1 = {2, 4, 5, -1, -3, -4};
        System.out.println(Arrays.toString(rearrangeArray(arr1)));
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(N)
    // Space Complexity: O(N)
    public static int[] rearrangeArray(int[] nums) {
        int[] result = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for (int num : nums){
            if (num > 0){
                result[positiveIndex] = num;
                positiveIndex += 2;
            }
            else {
                result[negativeIndex] = num;
                negativeIndex += 2;
            }
        }
        return result;
    }
}
