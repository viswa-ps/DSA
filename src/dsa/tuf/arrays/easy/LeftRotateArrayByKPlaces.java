package dsa.tuf.arrays.easy;

import java.util.Arrays;

public class LeftRotateArrayByKPlaces {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int[] arr2 = {3, 4, 1, 5, 3, -5};
        rotateArrayOptimal2(arr1, 2);
        rotateArrayOptimal2(arr2, 8);
        System.out.println(Arrays.toString(arr1));
        System.out.println(Arrays.toString(arr2));
    }

    //Brute Force
    /*
    Complexity Analysis
    Time Complexity: O(N)
    Space Complexity: O(k)
    */
    public static void rotateArrayBruteForce(int[] nums, int k) {
        int[] tempArray = new int[k];
        k %= nums.length;
        for (int i = 0; i < k; i++){
            tempArray[i] = nums[i];
        }
        for (int i = 0; i < nums.length; i++){
            if (i + k < nums.length){
                nums[i] = nums[i + k];
            }
            else{
                nums[i] = tempArray[(i + k) % nums.length];
            }
        }
    }


    //Optimal
    /*
    Complexity Analysis
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public static void rotateArrayOptimal1(int[] nums, int k) {
        k %= nums.length;
        if (k == 0){
            return;
        }
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, nums.length - 1);
        reverseArray(nums, 0, nums.length - 1);
    }

    private static void reverseArray(int[] arr, int start, int end){
        int mid = (start + end) / 2;
        for (int i = start; i <= mid; i++){
            int temp = arr[i];
            arr[i] = arr[end - (i - start)];
            arr[end - (i - start)] = temp;
        }
    }

    //Optimal
    /*
    Complexity Analysis
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public static void rotateArrayOptimal2(int[] nums, int k) {
        k %= nums.length;
        reverseArrayTwoPointer(nums, 0, k - 1);
        reverseArrayTwoPointer(nums, k, nums.length - 1);
        reverseArrayTwoPointer(nums, 0, nums.length - 1);
    }
    private static void reverseArrayTwoPointer(int[] nums, int start, int end) {

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
