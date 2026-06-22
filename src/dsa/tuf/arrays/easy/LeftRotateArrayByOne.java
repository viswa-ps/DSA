package dsa.tuf.arrays.easy;

import java.util.Arrays;

public class LeftRotateArrayByOne {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {-1, 0, 3, 6};
        System.out.println(Arrays.toString(rotateArrayByOneBruteForce(arr2)));
        rotateArrayByOneBruteOptimal(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    //Brute Force
    /*
    Complexity Analysis
    Time Complexity: O(N)
    Space Complexity: O(N)
    */
    public static int[] rotateArrayByOneBruteForce(int[] nums){
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++){
            result[i] = nums[(i + 1) % nums.length];
        }
        return result;
    }


    //Optimal
    /*
    Complexity Analysis
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public static void rotateArrayByOneBruteOptimal(int[] nums){
        int temp = nums[0];
        for (int i = 0; i < nums.length - 1; i++){
            nums[i] = nums[i + 1];
        }
        nums[nums.length - 1] = temp;
    }
}
