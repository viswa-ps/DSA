package dsa.tuf.arrays.easy;

import java.util.Arrays;

public class IntersectionOfTwoSortedArrays {
    //TODO : Given two sorted arrays, nums1 and nums2, return an array containing the intersection of these two arrays.
    // Each element in the result must appear as many times as it appears in both arrays;
    // that is, if an element appears x times in nums1 and y times in nums2,
    // it should appear min(x, y) times in the result.
    // Example
    // Input: nums1 = [1, 2, 2, 3, 5], nums2 = [1, 2, 7]
    // Output: [1, 2]
    // Explanation:
    // The elements 1, 2 are the only elements present in both nums1 and nums2
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 2, 3, 5};
        int[] arr2 = {1, 2, 7};
        int[] arr3 = {1, 2, 2, 3, 3, 3};
        int[] arr4 = {2, 3, 3, 4, 5, 7};
        System.out.println(Arrays.toString(intersectionArray(arr1, arr2)));
        System.out.println(Arrays.toString(intersectionArray(arr3, arr4)));
    }

    //Optimal
    /*
    Complexity Analysis
    Time Complexity: O(N + M)
    Space Complexity: O(min(m, n))
    */
    public static int[] intersectionArray(int[] nums1, int[] nums2) {
        int[] intersection = new int[Math.min(nums1.length, nums2.length)];
        int ptr1 = 0, ptr2 = 0, ptr3 = 0;
        while (ptr1 < nums1.length && ptr2 < nums2.length){
            if (nums1[ptr1] == nums2[ptr2]){
                intersection[ptr3] = nums1[ptr1];
                ptr3++;
                ptr1++;
                ptr2++;
            }
            else if (nums1[ptr1] < nums2[ptr2]){
                ptr1++;
            }
            else{
                ptr2++;
            }
        }
        return intersection;
    }
}
