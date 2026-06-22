package dsa.tuf.arrays.easy;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] arr1 = {0, 0, 3, 3, 5, 6};
        int[] arr2 = {-2, 2, 4, 4, 4, 4, 5, 5};
        System.out.println(removeDuplicates(arr1) + " -> " + Arrays.toString(arr1));
        System.out.println(removeDuplicates(arr2) + " -> " + Arrays.toString(arr2));
    }

    //Optimal
    /*
    Complexity Analysis
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public static int removeDuplicates(int[] nums) {
        int prev = 0;
        for (int i = 1; i < nums.length; i++){
            if (nums[prev] != nums[i]){
                prev++;
                nums[prev] = nums[i];
            }
        }
        return prev+1;
    }
}
