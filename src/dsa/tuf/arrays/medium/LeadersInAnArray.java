package dsa.tuf.arrays.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LeadersInAnArray {
    //TODO: Given an integer array nums, return a list of all the leaders in the array.
    // A leader in an array is an element whose value is strictly greater than all elements
    // to its right in the given array. The rightmost element is always a leader.
    // The elements in the leader array must appear in the order they appear in the nums array.
    // Example
    // Input: nums = [1, 2, 5, 3, 1, 2]
    // Output: [5, 3, 2]
    // Explanation:
    // 2 is the rightmost element, 3 is the largest element in the index range [3, 5],
    // 5 is the largest element in the index range [2, 5]
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 5, 3, 1, 2};
        int[] arr2 = {-3, 4, 5, 1, -4, -5};
        System.out.println(leaders(arr1));
        System.out.println(leaders(arr2));
    }

    //NOTE: Optimal Approach
    // Complexity Analysis
    // Time Complexity: O(N)
    // Space Complexity: O(N),  to store the elements in the answer array and return it.
    // The auxiliary space (excluding the output array) is strictly O(1) since no additional intermediate data structures are utilized.
    public static List<Integer> leaders(int[] nums) {
        List<Integer> leaders = new ArrayList<>();
        int currentMax = nums[nums.length - 1];
        leaders.add(currentMax);
        if (nums.length == 1){

            return leaders;
        }
        for (int i = nums.length - 2; i >= 0; i--){
            if (nums[i] > currentMax){
                leaders.add(nums[i]);
                currentMax = nums[i];
            }
        }
        Collections.reverse(leaders);
        return leaders;
    }
}
