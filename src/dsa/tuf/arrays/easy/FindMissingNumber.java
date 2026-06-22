package dsa.tuf.arrays.easy;

public class FindMissingNumber {
    //TODO: Given an integer array of size n containing distinct values in the range from 0 to n (inclusive),
    // return the only number missing from the array within this range.
    // Example
    // --------
    // Input: nums = [0, 2, 3, 1, 4]
    // Output: 5
    // Explanation:
    // nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing number in the range [0, 5]
    public static void main(String[] args) {
        int[] arr1 = {1, 3, 6, 4, 2, 5};
        int[] arr2 = {0, 1, 2, 4, 5, 6};
        System.out.println(missingNumberOptimal2(arr1));
        System.out.println(missingNumberOptimal2(arr2));
    }

    //Optimal1
    /*
    Complexity Analysis
    Time Complexity: O(N)
    Space Complexity: O(1)
    */
    public static int missingNumberOptimal1(int[] nums) {
        int n = nums.length;
        int actualSum = 0;
        int expectedSum = (n * (n + 1)) / 2;
        for (int num : nums){
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    //Optimal2
    //NOTE: Another optimal approach, uses the below property of XOR to find the missing number.
    // XOR of two same numbers is 0.
    // The XOR of a number with 0 is the number itself
    // Understand that on calculating the XOR of all numbers from 1 to N
    // we make sure that each number is included. After that on calculating
    // the XOR of all the elements in the array & then performing XOR these two results,
    // all the numbers present in the final result will appear twice expect for the one which is missing.
    // Hence the number occurring twice turn out 0 satisfying first condition,
    // and then followed by 0 ^ missing number, leaving the missing number itself.

    public static int missingNumberOptimal2(int[] nums) {
        int xor1 = 0;
        int xor2 = 0;
        for (int i = 0; i < nums.length; i++){
            xor1 ^= (i + 1);
            xor2 ^= nums[i];
        }
        return xor1 ^ xor2;
    }
}
