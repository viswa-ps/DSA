package dsa.tuf.arrays.easy;

import java.util.Arrays;

public class MoveZerosToEnd {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 4, 0, 5, 2};
        int[] arr2 = {0, 0, 0, 1, 3, -2};
        int[] arr3 = {9};
        moveZeroesOptimal(arr1);
        moveZeroesOptimal(arr2);
        moveZeroesOptimal(arr3);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));

    }

    //Optimal
    /*
    Complexity Analysis
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public static void moveZeroesOptimal(int[] nums) {
        int zeroPointer = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] != 0){
                int temp = nums[zeroPointer];
                nums[zeroPointer] = nums[i];
                nums[i] = temp;
                zeroPointer++;
            }
        }
    }
}
