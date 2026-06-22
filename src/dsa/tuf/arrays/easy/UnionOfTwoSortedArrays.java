package dsa.tuf.arrays.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnionOfTwoSortedArrays {

    //TODO : Given two sorted arrays nums1 and nums2,
    // return an array that contains the union of these two arrays.
    // The elements in the union must be in ascending order.
    // The union of two arrays is an array where all values are distinct
    // and are present in either the first array, the second array, or both.
    // Example
    // Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
    // Output: [1, 2, 3, 4, 5, 7]
    // Explanation:
    // The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5};
        int[] nums2 = {1, 2, 7};
        int[] nums3 = {3, 4, 6, 7, 9, 9};
        int[] nums4 = {1, 5, 7, 8, 8};
        System.out.println(Arrays.toString(unionArray2(nums1, nums2)));
        System.out.println(Arrays.toString(unionArray2(nums3, nums4)));
    }

    //Optimal
    /*
    Complexity Analysis
    Time Complexity: O(N + M)
    Space Complexity: O(N + M)
    */
    public static int[] unionArray(int[] nums1, int[] nums2) {
        int[] union = new int[nums1.length + nums2.length];
        int ptr1 = 0, ptr2 = 0, ptr3 = 0;
        while (ptr1 < nums1.length && ptr2 < nums2.length){
            if (nums1[ptr1] < nums2[ptr2]){
                if (ptr3 == 0 || nums1[ptr1] != union[ptr3 - 1]){
                    union[ptr3] = nums1[ptr1];
                    ptr3++;
                }
                ptr1++;
            }
            else if (nums1[ptr1] > nums2[ptr2]){
                if (ptr3 == 0 || nums2[ptr2] != union[ptr3 - 1]){
                    union[ptr3] = nums2[ptr2];
                    ptr3++;
                }
                ptr2++;
            }
            else{
                if (ptr3 == 0 || nums2[ptr2] != union[ptr3 - 1]){
                    union[ptr3] = nums2[ptr2];
                    ptr3++;
                }
                ptr1++;
                ptr2++;
            }
        }
        while (ptr1 < nums1.length){
            if (ptr3 == 0 || union[ptr3 - 1] != nums1[ptr1]){
                union[ptr3] = nums1[ptr1];
                ptr3++;
            }
            ptr1++;
        }
        while (ptr2 < nums2.length){
            if (ptr3 == 0 || union[ptr3 - 1] != nums2[ptr2]){
                union[ptr3] = nums2[ptr2];
                ptr3++;
            }
            ptr2++;
        }
        return union;
    }

    public static int[] unionArray2(int[] nums1, int[] nums2) {
        List<Integer> union = new ArrayList<>();

        int ptr1 = 0, ptr2 = 0;

        while (ptr1 < nums1.length && ptr2 < nums2.length) {

            if (nums1[ptr1] < nums2[ptr2]) {
                if (union.isEmpty() || union.get(union.size() - 1) != nums1[ptr1]) {
                    union.add(nums1[ptr1]);
                }
                ptr1++;
            }
            else if (nums1[ptr1] > nums2[ptr2]) {
                if (union.isEmpty() || union.get(union.size() - 1) != nums2[ptr2]) {
                    union.add(nums2[ptr2]);
                }
                ptr2++;
            }
            else {
                if (union.isEmpty() || union.get(union.size() - 1) != nums1[ptr1]) {
                    union.add(nums1[ptr1]);
                }
                ptr1++;
                ptr2++;
            }
        }

        while (ptr1 < nums1.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != nums1[ptr1]) {
                union.add(nums1[ptr1]);
            }
            ptr1++;
        }

        while (ptr2 < nums2.length) {
            if (union.isEmpty() || union.get(union.size() - 1) != nums2[ptr2]) {
                union.add(nums2[ptr2]);
            }
            ptr2++;
        }

        return union.stream().mapToInt(Integer::intValue).toArray();
    }
}
